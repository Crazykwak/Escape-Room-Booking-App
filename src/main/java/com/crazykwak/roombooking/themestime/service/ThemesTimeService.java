package com.crazykwak.roombooking.themestime.service;

import com.crazykwak.roombooking.exception.BusinessException;
import com.crazykwak.roombooking.exception.ExceptionCode;
import com.crazykwak.roombooking.themestime.domain.ThemesTime;
import com.crazykwak.roombooking.themestime.dto.ThemesTimeUpdateDto;
import com.crazykwak.roombooking.themestime.repository.ThemesTimeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ThemesTimeService {

    private final ThemesTimeJpaRepository repository;

    @Transactional
    public ThemesTime save(ThemesTime themesTime) {
        return repository.save(themesTime);
    }

    @Transactional
    public ThemesTime update(Long themesTimeId, ThemesTimeUpdateDto updateParam) {
        ThemesTime findThemesTime = verifiedThemesTime(themesTimeId);

        Optional.ofNullable(updateParam.getStartTime())
                .ifPresent(localDateTime -> findThemesTime.setStartTime(localDateTime));
        Optional.ofNullable(updateParam.getRound())
                .ifPresent(round -> findThemesTime.setRound(round));

        return findThemesTime;
    }

    public List<ThemesTime> findAll() {
        return repository.findAll();
    }

    @Transactional
    public void delete(Long themesTimeId) {
        ThemesTime themesTime = verifiedThemesTime(themesTimeId);
        repository.delete(themesTime);
    }

    private ThemesTime verifiedThemesTime(Long themesTimeId) {
        return repository.findById(themesTimeId).orElseThrow(
                () -> new BusinessException(ExceptionCode.THEMESTIME_NOT_FOUND)
        );
    }
}
