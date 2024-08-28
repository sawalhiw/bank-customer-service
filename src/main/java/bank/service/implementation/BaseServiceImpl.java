package bank.service.implementation;

import bank.dto.BaseDto;
import bank.entity.BaseEntity;
import bank.exception.NotFoundException;
import bank.mapper.BaseMapper;
import bank.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class BaseServiceImpl<ENTITY extends BaseEntity, DTO extends BaseDto> {

    private static final Logger logger = LogManager.getLogger(BaseServiceImpl.class);

    private final BaseRepository<ENTITY> repository;
    private final BaseMapper<DTO, ENTITY> mapper;

    public Page<DTO> findAll(final Pageable pageable) {
        logger.debug("Finding all entities with pageable: {}", pageable);
        Page<DTO> result = mapper.buildDtoPage(repository.findAll(pageable));
        logger.debug("Found {} entities", result.getTotalElements());
        return result;
    }

    public DTO findById(final String id) {
        logger.debug("Finding entity by ID: {}", id);
        ENTITY entity = repository.findById(id)
                .orElseThrow(() -> {
                    String message = String.format("Entity with ID [%s] does not exist.", id);
                    logger.error(message);
                    return new NotFoundException(message);
                });
        DTO dto = mapper.toDto(entity);
        logger.debug("Found entity: {}", dto);
        return dto;
    }

    public DTO create(final DTO dto) {
        ENTITY entity = mapper.toEntity(dto);
        DTO result = mapper.toDto(repository.save(entity));
        logger.info("Created entity with ID: {}", dto.getId());
        return result;
    }

    public DTO updateById(final DTO dto, final String id) {
        validateIfEntityExists(id);
        dto.setId(id);
        ENTITY entity = mapper.toEntity(dto);
        DTO result = mapper.toDto(repository.save(entity));
        logger.info("Updated entity with ID: {}", id);
        return result;
    }

    public DTO deleteById(final String id) {
        DTO dto = this.findById(id);
        repository.deleteById(id);
        logger.info("Deleted entity with ID: {}", id);
        return dto;
    }

    public void validateIfEntityExists(final String id) {
        logger.debug("Validating existence of entity with ID: {}", id);
        if (!repository.existsById(id)) {
            String message = String.format("Entity with ID [%s] does not exist.", id);
            logger.error(message);
            throw new NotFoundException(message);
        }
        logger.debug("Entity with ID: {} exists", id);
    }
}