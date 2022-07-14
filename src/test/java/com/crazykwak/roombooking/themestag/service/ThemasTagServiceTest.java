package com.crazykwak.roombooking.themestag.service;

import com.crazykwak.roombooking.franchise.domain.Franchise;
import com.crazykwak.roombooking.franchise.service.FranchiseService;
import com.crazykwak.roombooking.store.domain.Store;
import com.crazykwak.roombooking.store.service.StoreService;
import com.crazykwak.roombooking.tag.domain.Tag;
import com.crazykwak.roombooking.tag.service.TagService;
import com.crazykwak.roombooking.themes.domain.Themes;
import com.crazykwak.roombooking.themes.service.ThemesService;
import com.crazykwak.roombooking.themestag.domain.ThemesTag;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ThemasTagServiceTest {

    @Autowired
    ThemesTagService themesTagService;
    @Autowired
    ThemesService themesService;
    @Autowired
    StoreService storeService;
    @Autowired
    FranchiseService franchiseService;
    @Autowired
    TagService tagService;

    @Test
    @Commit
    void save() {
        Franchise franchise = new Franchise("넥스트에디션", "서울", "010-1111-1111", "naver.com");
        Franchise save = franchiseService.save(franchise);

        Store store = new Store("넥스트에디션 건대점", "010-1111-1111", "건대점", "하이", save);
        Store savedStore = storeService.save(store);

        Themes themes = new Themes("몬스터", "별5개", 4, 75, savedStore);
        Themes savedThemes = themesService.save(themes);
        Long themesId = savedThemes.getId();

        Tag tag = new Tag("공포");
        Tag savedTag = tagService.save(tag);
        Long tagId = savedTag.getId();

        ThemesTag themesTag = new ThemesTag(savedThemes, savedTag);
        ThemesTag savedThemesTag = themesTagService.save(themesTag);

        assertThat(savedThemesTag.getThemes().getId()).isEqualTo(themesId);
        assertThat(savedThemesTag.getTag().getId()).isEqualTo(tagId);
    }
}