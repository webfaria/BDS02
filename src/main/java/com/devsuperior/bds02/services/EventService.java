package com.devsuperior.bds02.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;

@Service
public class EventService {

	private EventRepository repository;

	/*
	 * @Autowired private CityRepository cityRepository;
	 */

	@Transactional
	public EventDTO update(Long id, EventDTO dto) {
		try {
			Event entity = repository.getOne(id);
			// copyDtoToEntity(dto, entity);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new EventDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	/*
	 * private void copyDtoToEntity(EventDTO dto, Event entity) {
	 * entity.setName(dto.getName()); entity.setDate(dto.getDate());
	 * entity.setUrl(dto.getUrl());
	 * 
	 * 
	 * entity.getCities().clear(); for (CityDTO citDto : dto.getCities()) { City
	 * city = cityRepository.getOne(citDto.getId()); entity.getCities().add(city); }
	 * 
	 * }
	 */
}
