package com.seiton.familybudget.service;

import com.seiton.familybudget.exception.SpaceNotFoundException;
import com.seiton.familybudget.model.Space;
import com.seiton.familybudget.repository.SpaceRepository;
import org.springframework.stereotype.Service;

@Service
public class SpaceService {
    private final SpaceRepository spaceRepository;


    public SpaceService(SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    public Space getSpace(long id){
        return spaceRepository.findById(id).orElseThrow(
                () -> new SpaceNotFoundException()
        );
    }

    public long addSpace(Space space){
        return spaceRepository.save(space).getId();
    }

    public void deleteSpace(long id){
        spaceRepository.deleteById(id);
    }

    public void updateSpace(long id, Space space){
        if (spaceRepository.existsById(id)) {
            space.setId(id);
            spaceRepository.save(space);
        } else {
            throw new SpaceNotFoundException();
        }
    }
}
