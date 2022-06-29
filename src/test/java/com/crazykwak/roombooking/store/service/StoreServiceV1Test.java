package com.crazykwak.roombooking.store.service;

import com.crazykwak.roombooking.franchise.domain.Franchise;
import com.crazykwak.roombooking.store.domain.Store;
import com.crazykwak.roombooking.store.dto.StoreSearchCond;
import com.crazykwak.roombooking.store.dto.StoreUpdateDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class StoreServiceV1Test {

    @Autowired
    StoreService service;

    @Test
    void save() {
        Store store = new Store();

        Store save = service.save(store);
        Long id = save.getId();
        Store findStore = service.findById(id).orElseThrow();

        assertThat(id).isEqualTo(findStore.getId());
    }

    @Test
    void update() {
        Franchise franchise = new Franchise();
        Store store = new Store("넥스트에디션 강남점", "010-2090-6512", "강남구", "존나 재밌음", franchise);
        Store save = service.save(store);
        String storeName = save.getStoreName();
        StoreUpdateDto updateDto = new StoreUpdateDto();
        String s = "존나 재미 없음";
        updateDto.setInfo(s);

        service.update(save.getId(), updateDto);

        assertThat(s).isEqualTo(save.getInfo());

    }

    @Test
    void delete() {
        Store store1 = new Store();
        Store store2 = new Store();

        service.save(store1);
        Store save = service.save(store2);
        Long id = save.getId();

        service.delete(id);

        assertThatThrownBy(() -> service.findById(id).orElseThrow()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void findAll() {
        StoreSearchCond cone = new StoreSearchCond();
        Store store3 = new Store();
        Store store4 = new Store();

        service.save(store3);
        service.save(store4);

        List<Store> all = service.findAll(cone);

        assertThat(all.size()).isEqualTo(2);
    }
}