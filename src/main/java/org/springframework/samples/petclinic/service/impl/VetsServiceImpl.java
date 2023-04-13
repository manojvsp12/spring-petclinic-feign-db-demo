package org.springframework.samples.petclinic.service.impl;

import org.springframework.samples.petclinic.dto.Vets;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.service.VetsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VetsServiceImpl implements VetsService {

	private final VetRepository vetRepository;

	public Vets getVetList() {
		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetRepository.findAll());
		return vets;
	}

}
