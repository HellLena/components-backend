package org.example.components.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.components.enumerations.BomStatus;
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

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final FileService fileService;
    private final ParserHandlerFactory parserHandlerFactory;

    private static final String BOM_DIRECTORY = "bom/";

    @Override
    public void createUnit(UnitCreateDto unitCreateDto) {
        unitRepository.create(unitCreateDto);
    }

    @Override
    public List<UnitListDto> getUnits(int page, int pageSize, String sortBy, String orderBy) {
        return unitRepository.findAllPaged(page, pageSize, sortBy, orderBy);
    }

    @Override
    public UnitDto getUnit(Long unitId) {
        return unitRepository.findById(unitId);
    }

    @Override
    public void updateUnit(Long unitId, UnitCreateDto unitCreateDto) {
        unitRepository.update(unitId, unitCreateDto);
    }

    @Override
    public void uploadBomFile(Long unitId, MultipartFile file) {
        String filePath = fileService.uploadFile(BOM_DIRECTORY, file);
        unitRepository.updateBomFile(unitId, filePath, file.getName(), BomStatus.NEW);
        parseFile(unitId, file);
    }

    @Async
    private void parseFile(Long unitId, MultipartFile file) {
        unitRepository.updateBomFileStatus(unitId, BomStatus.PROCESSING);

        List<BomFileData> bomFileData = fileService.parseFile(file, BomFileData.class);
        BomDataWrapper dataWrapper = new BomDataWrapper(unitId, bomFileData);
        parserHandlerFactory.getHandlers(BomDataWrapper.class)
                .stream()
                .sorted(Comparator.comparing(h -> h.getClass().getAnnotation(Order.class).value()))
                .forEach(handler -> handler.handle(dataWrapper));
    }
}
