package com.crazykwak.roombooking.themes.service;

import com.crazykwak.roombooking.exception.BusinessException;
import com.crazykwak.roombooking.franchise.domain.Franchise;
import com.crazykwak.roombooking.franchise.service.FranchiseService;
import com.crazykwak.roombooking.store.domain.Store;
import com.crazykwak.roombooking.store.service.StoreService;
import com.crazykwak.roombooking.themes.domain.Themes;
import com.crazykwak.roombooking.themes.dto.ThemesUpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class ThemesServiceTest {

    @Autowired
    ThemesService service;
    @Autowired
    StoreService storeService;
    @Autowired
    FranchiseService franchiseService;

    @Test
    void save() {
        Store store = new Store("넥스트에디션 건대점", "010-1111-1111", "건대점", "하이", new Franchise());
        Themes themes = new Themes("몬스터", "별5개", 4, 75, store);
        service.save(themes);
        Themes find = service.findById(themes.getId());
        assertThat(find.getName()).isEqualTo(themes.getName());
    }

    @Test
    void update() {
        Store store = new Store("넥스트에디션 강남점", "010-1111-1111", "건대점", "하이", new Franchise());
        Themes themes = new Themes("몬스터", "별5개", 4, 75, store);
        Themes save = service.save(themes);

        String s = "만스터";
        ThemesUpdateDto updateParam = new ThemesUpdateDto("만스터", null, null, null);
        service.update(save.getId(), updateParam);
        assertThat(s).isEqualTo(save.getName());

    }

    @Test
    void delete() {
        Store store = new Store("넥스트에디션 강남점", "010-1111-1111", "건대점", "하이", new Franchise());
        Themes themes1 = new Themes("몬스터", "별5개", 4, 75, store);
        service.save(themes1);

        Long id = themes1.getId();

        service.delete(id);

        assertThatThrownBy(() -> service.findById(id)).isInstanceOf(BusinessException.class);
    }

    @Test
    void findAllThemes() {
        Franchise franchise = new Franchise("넥스트에디션", "강남구", "010-1111-1111", "asdf.com");
        Franchise fsave = franchiseService.save(franchise);
        Store store = new Store("넥스트에디션 서현점", "010-1111-1111", "건대점", "하이", fsave);
        Store save = storeService.save(store);
        Themes themes3 = new Themes("몬스터", "별5개", 4, 75, save);
        Themes themes4 = new Themes("말랑말랑", "별5개", 4, 75, save);

        service.save(themes3);
        service.save(themes4);

        List<Themes> allThemes = service.findAllThemes();
        assertThat(2).isEqualTo(allThemes.size());

        
    }



}