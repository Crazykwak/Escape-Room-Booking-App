package com.crazykwak.roombooking.franchise.service;

import com.crazykwak.roombooking.exception.BusinessException;
import com.crazykwak.roombooking.franchise.domain.Franchise;
import com.crazykwak.roombooking.franchise.dto.FranchiseUpdateDto;
import com.crazykwak.roombooking.franchise.repository.jpa.FranchiseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.crazykwak.roombooking.exception.ExceptionCode.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FranchiseService {

    private final FranchiseJpaRepository repository;

    @Transactional
    public Franchise save(Franchise franchise) {
        verifyFranchise(franchise);
        return repository.save(franchise);
    }

    @Transactional
    public void update(Long franchiseId, FranchiseUpdateDto updateParam) {
        Franchise find = findVerifiedFranchise(franchiseId);

        Optional.ofNullable(updateParam.getName())
                .ifPresent(name -> find.setName(name));
        Optional.ofNullable(updateParam.getAddress())
                .ifPresent(address -> find.setAddress(address));
        Optional.ofNullable(updateParam.getHomepage())
                .ifPresent(homepage -> find.setHomepage(homepage));
        Optional.ofNullable(updateParam.getTel())
                .ifPresent(tel -> find.setTel(tel));
    }

    public Franchise findById(Long franchiseId) {
        return findVerifiedFranchise(franchiseId);
    }

    public List<Franchise> findAllFranchise() {
        return repository.findAll();
    }

    public void delete(Long franchiseId) {
        Franchise franchise = findVerifiedFranchise(franchiseId);
        repository.delete(franchise);
    }

    public void verifyFranchise(Franchise franchise) {
        Optional<Franchise> find = repository.findByName(franchise.getName());
        if(find.isPresent()) {
            throw new BusinessException(FRANCHISE_EXISTS);
        }
    }

    public Franchise findVerifiedFranchise(Long franchiseId) {
        return repository.findById(franchiseId).orElseThrow(
                () -> new BusinessException(FRANCHISE_NOT_FOUND)
        );
    }


}
