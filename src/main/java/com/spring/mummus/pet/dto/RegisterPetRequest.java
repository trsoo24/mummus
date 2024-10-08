package com.spring.mummus.pet.dto;

import com.spring.mummus.pet.entity.Pet;
import com.spring.mummus.pet.enums.Gender;
import com.spring.mummus.pet.enums.PetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterPetRequest {
    private String name;
    private Integer age;
    private Gender gender;
    private PetType petType;
    private Long memberId;

    public Pet toEntity() {
        return Pet.builder()
                .name(this.getName())
                .age(this.getAge())
                .gender(this.getGender())
                .petType(this.getPetType())
                .memberId(this.getMemberId())
                .build();
    }
}
