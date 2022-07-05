package com.crazykwak.roombooking.themes.service;

import com.crazykwak.roombooking.exception.BusinessException;
import com.crazykwak.roombooking.exception.ExceptionCode;
import com.crazykwak.roombooking.themes.domain.Themes;
import com.crazykwak.roombooking.themes.dto.ThemesUpdateDto;
import com.crazykwak.roombooking.themes.repository.jpa.ThemesJpaRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ThemesService {

    private final ThemesJpaRepository repository;

    @Transactional
    public Themes save(Themes themes) {
        verifyThemes(themes);
        return repository.save(themes);
    }

    @Transactional
    public void update(Long themesId, ThemesUpdateDto updateParam) {
        Themes findThemes = findVerifyThemes(themesId);

        Optional.ofNullable(updateParam.getName())
                .ifPresent(name -> findThemes.setName(name));
        Optional.ofNullable(updateParam.getHard())
                .ifPresent(hard -> findThemes.setHard(hard));
        Optional.ofNullable(updateParam.getPeople())
                .ifPresent(people -> findThemes.setPeople(people));
        Optional.ofNullable(updateParam.getTime())
                .ifPresent(time -> findThemes.setTime(time));
    }

    public Themes findById(Long themesId) {
        return findVerifyThemes(themesId);
    }

    public void delete(Long themesId) {
        Themes themes = findVerifyThemes(themesId);
        repository.delete(themes);
    }

    public List<Themes> findAllThemes() {
        return repository.findAll();
    }

    public Themes findVerifyThemes(Long themesId) {
        return repository.findById(themesId).orElseThrow(
                () -> new BusinessException(ExceptionCode.THEMES_NOT_FOUND)
        );
    }

    public void verifyThemes(Themes themes) {
        Optional<Themes> findThemes = repository.findByName(themes.getName());
        if(findThemes.isPresent()) {
            throw new BusinessException(ExceptionCode.THEMES_EXISTS);
        }
    }

}
