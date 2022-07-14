package com.crazykwak.roombooking.themestag.service;

import com.crazykwak.roombooking.exception.BusinessException;
import com.crazykwak.roombooking.exception.ExceptionCode;
import com.crazykwak.roombooking.themestag.domain.ThemesTag;
import com.crazykwak.roombooking.themestag.repository.ThemasTagJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ThemesTagService {

    private final ThemasTagJpaRepository repository;

    @Transactional
    public ThemesTag save(ThemesTag themesTag) {
        return repository.save(themesTag);
    }

    public ThemesTag findById(Long themesId) {
        return findVerifiedThemesTag(themesId);
    }

    public ThemesTag findVerifiedThemesTag(Long themesId) {
        Optional<ThemesTag> find = repository.findById(themesId);
        ThemesTag themesTag = find.orElseThrow(() -> new BusinessException(ExceptionCode.THEMESTAG_NOT_FOUND));
        return themesTag;
    }

    @Transactional
    public void delete(Long themesId) {
        ThemesTag find = findVerifiedThemesTag(themesId);
        repository.delete(find);
    }

    @Transactional
    public void update(Long themesId, ThemesTag themesTag) {
        ThemesTag find = findVerifiedThemesTag(themesId);

        Optional.ofNullable(themesTag.getThemes())
                .ifPresent(themes -> find.setThemes(themes));
        Optional.ofNullable(themesTag.getTag())
                .ifPresent(tag -> find.setTag(tag));
    }

}
