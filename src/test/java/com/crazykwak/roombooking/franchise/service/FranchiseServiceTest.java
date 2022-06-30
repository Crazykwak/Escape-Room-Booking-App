package com.crazykwak.roombooking.franchise.service;

import com.crazykwak.roombooking.exception.BusinessException;
import com.crazykwak.roombooking.franchise.domain.Franchise;
import com.crazykwak.roombooking.franchise.dto.FranchiseUpdateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class FranchiseServiceTest {

    @Autowired
    FranchiseService service;

    @Test
    void save() {
        Franchise franchise = new Franchise();

        Franchise save = service.save(franchise);
        Long findId = save.getFranchiseId();
        Franchise findFranchise = service.findById(findId);

        assertThat(findId).isEqualTo(findFranchise.getFranchiseId());
    }

    @Test
    void update() {
        Franchise franchise = new Franchise("넥스트에디션", "서울", "010-1111-1111", "naver.com");
        Franchise save = service.save(franchise);
        String address = save.getAddress();

        String s = "성남";
        FranchiseUpdateDto updateDto = new FranchiseUpdateDto();
        updateDto.setAddress(s);

        service.update(save.getFranchiseId(), updateDto);

        assertThat(s).isEqualTo(save.getAddress());
    }

    @Test
    void findAllFranchise() {
        Franchise franchise1 = new Franchise("넥스트에디션", "서울", "010-1111-1111", "naver.com");
        Franchise franchise2 = new Franchise("솔버", "서울", "010-1111-1111", "naver.com");

        service.save(franchise1);
        service.save(franchise2);

        List<Franchise> allFranchise = service.findAllFranchise();

        assertThat(2).isEqualTo(allFranchise.size());
    }

    @Test
    void delete() {
        Franchise franchise3 = new Franchise("넥스트에디션", "서울", "010-1111-1111", "naver.com");
        Franchise franchise4 = new Franchise("넥스", "서울", "010-1111-1111", "naver.com");

        service.save(franchise3);
        Franchise save = service.save(franchise4);

        service.delete(save.getFranchiseId());

        assertThatThrownBy(() -> service.findById(save.getFranchiseId()))
                .isInstanceOf(BusinessException.class);


    }
}