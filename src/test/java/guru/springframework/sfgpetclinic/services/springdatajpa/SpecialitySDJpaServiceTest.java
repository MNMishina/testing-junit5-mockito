package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

  @Mock
  SpecialtyRepository specialtyRepository;

  @InjectMocks
  SpecialitySDJpaService service;

  @Test
  void findById() {
    Speciality speciality = new Speciality();
    when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
    Speciality foundSpeciality = service.findById(1L);

    assertThat(foundSpeciality).isNotNull();

    verify(specialtyRepository).findById(1L);
  }

  @Test
  void deleteById() {
    service.deleteById(1l);
    verify(specialtyRepository).deleteById(1l);
  }

  @Test
  void testDelete() {
    service.delete(new Speciality());
  }

  @Test
  void testDeleteByObject() {
    Speciality speciality = new Speciality();

    service.delete(speciality);
    verify(specialtyRepository).delete(any(Speciality.class));
  }
}