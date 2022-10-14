package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.components.enumerations.BomFileStatus;
import org.example.components.handler.ParserHandlerFactory;
import org.example.components.model.UnitDto;
import org.example.components.model.create.UnitCreateDto;
import org.example.components.model.list.UnitListDto;
import org.example.components.model.parser.BomDataWrapper;
import org.example.components.model.parser.BomFileData;
import org.example.components.repository.UnitRepository;
import org.example.components.service.FileService;
import org.example.components.service.UnitService;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final FileService fileService;
    private final ParserHandlerFactory parserHandlerFactory;

    private static final String BOM_DIRECTORY = "bom";

    @Override
    public void create(UnitCreateDto dto) {
        unitRepository.create(dto);
    }

    @Override
    public List<UnitListDto> getAllPaged(int page, int pageSize, String sortBy, String order) {
        return unitRepository.findAllPaged(page, pageSize, sortBy, order);
    }

    @Override
    public UnitDto getById(Long unitId) {
        return unitRepository.findById(unitId);
    }

    @Override
    public void update(Long unitId, UnitCreateDto dto) {
        unitRepository.update(unitId, dto);
    }

    @Override
    public void uploadBomFile(Long unitId, MultipartFile file) {
        // TODO: add validation that file has .csv format
        String filePath = fileService.uploadFile(BOM_DIRECTORY, file);
        log.debug("File '{}' for unit id={} was stored in path: {}", file.getOriginalFilename(), unitId, filePath);
        unitRepository.updateBomFile(unitId, filePath, file.getOriginalFilename(), BomFileStatus.NEW);
        parseFile(unitId, file);
    }

    @Async
    private void parseFile(Long unitId, MultipartFile file) {
        unitRepository.updateBomFileStatus(unitId, BomFileStatus.PROCESSING);

        try {
            log.debug("Parsing started for unit id={}, file: {}", unitId, file.getOriginalFilename());
            List<BomFileData> bomFileData = fileService.parseFile(file, BomFileData.class);
            BomDataWrapper dataWrapper = new BomDataWrapper(unitId, bomFileData);
            parserHandlerFactory.getHandlers(BomDataWrapper.class)
                    .stream()
                    .sorted(Comparator.comparing(h -> h.getClass().getAnnotation(Order.class).value()))
                    .forEach(handler -> handler.handle(dataWrapper));
        } catch (Exception e) {
            log.error("Error occurred while handling BOM file: ", e);
            unitRepository.updateBomFileStatus(unitId, BomFileStatus.FAILED);
        }

        unitRepository.updateBomFileStatus(unitId);
    }
}
