package greencity.service.impl;

import greencity.dto.habit.HabitAssignDto;
import greencity.dto.habit.HabitDto;
import greencity.dto.habitstatistic.HabitStatisticDto;
import greencity.dto.habittranslation.HabitTranslationDto;
import greencity.entity.*;
import greencity.entity.enums.HabitRate;
import greencity.exception.exceptions.WrongIdException;
import greencity.repository.HabitAssignRepo;
import greencity.service.HabitService;
import greencity.service.HabitStatisticService;
import greencity.service.HabitStatusService;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.modelmapper.TypeToken;

@ExtendWith(MockitoExtension.class)
class HabitAssignServiceImplTest {
    @Mock //(lenient = true)
    HabitService habitService;
    @Mock //(lenient = true)
    HabitAssignRepo habitAssignRepo;
    @Mock //(lenient = true)
    HabitStatisticService habitStatisticService;
    @Mock //(lenient = true)
    HabitStatusService habitStatusService;
    @Mock //(lenient = true)
    ModelMapper modelMapper;
    @InjectMocks
    HabitAssignServiceImpl habitAssignService;

    private ZonedDateTime zonedDateTime = ZonedDateTime.now();

    private HabitDto habitDto =
        HabitDto.builder().id(1L).build();

    private HabitAssignDto habitAssignDto =
        HabitAssignDto.builder().id(1L)
            .createDateTime(zonedDateTime).habit(habitDto).suspended(false).build();

    private Habit habit =
        Habit.builder().id(1L).image("src/main/resources/static/css/background-image-footer.svg").build();

    private User user =
        User.builder().id(1L).build();

    private HabitAssign habitAssign = HabitAssign.builder().id(1L)
        .suspended(false).createDate(zonedDateTime).user(user).habit(habit).build();

    private List<HabitAssignDto> habitAssignDtos = Collections.singletonList(habitAssignDto);

    private List<HabitAssign> habitAssigns = Collections.singletonList(habitAssign);



    @Test
    void getByIdTest() {
        when(habitAssignRepo.findById(1L)).thenReturn(Optional.of(habitAssign));
        when(modelMapper.map(habitAssign, HabitAssignDto.class)).thenReturn(habitAssignDto);
        assertEquals(habitAssignDto, habitAssignService.getById(1L));
    }

    @Test
    void getByIdFailTest() {
        when(habitAssignRepo.findById(2L)).thenReturn(Optional.of(habitAssign));
        when(modelMapper.map(habitAssign, HabitAssignDto.class)).thenReturn(habitAssignDto);
        assertThrows(WrongIdException.class, () -> habitAssignService.getById(1L));
    }

    @Test
    void assignHabitForUserTest() {
        when (habitService.getById(1L)).thenReturn(habit);
        when (habitAssignRepo.findByHabitIdAndUserIdAndSuspendedFalse(habit.getId(), user.getId()))
            .thenReturn(Optional.empty());
        when (habitAssignRepo.findByHabitIdAndUserIdAndCreateDate(
            habit.getId(), user.getId(), zonedDateTime)).thenReturn(Optional.empty());
        when (habitAssignRepo.save(habitAssign)).thenReturn(habitAssign);
        habitStatusService.saveStatusByHabitAssign(habitAssign);
        when (modelMapper.map(habitAssign, HabitAssignDto.class)).thenReturn(habitAssignDto);
        HabitAssignDto actual = habitAssignService.assignHabitForUser(habit.getId(), user);
        assertEquals(habitAssignDto, actual );
    }

    @Test
    void findActiveHabitAssignByUserIdAndHabitIdTest() {
        when(habitService.getById(1L)).thenReturn(habit);
        when(habitAssignRepo.findByHabitIdAndUserIdAndSuspendedFalse(1L, 1L))
            .thenReturn(Optional.of(habitAssign));
        when(modelMapper.map(habitAssign,
            HabitAssignDto.class)).thenReturn(habitAssignDto);
        assertEquals(habitAssignDto, habitAssignService.findActiveHabitAssignByUserIdAndHabitId(1L, 1L));
    }

    @Test
    void findHabitAssignByUserIdAndHabitIdAndCreateDateTest() {
        when(habitService.getById(1L)).thenReturn(habit);
        when(habitAssignRepo.findByHabitIdAndUserIdAndCreateDate(1L, 1L,zonedDateTime))
            .thenReturn(Optional.of(habitAssign));
        when(modelMapper.map(habitAssign,
            HabitAssignDto.class)).thenReturn(habitAssignDto);
        assertEquals(habitAssignDto, habitAssignService
            .findHabitAssignByUserIdAndHabitIdAndCreateDate(1L, 1L,zonedDateTime));
    }

    @Test
    void getAllActiveHabitAssignsByUserIdTest() {
        when (habitAssignRepo.findAllByUserIdAndSuspendedFalse(1L)).thenReturn(habitAssigns);
        when (modelMapper.map(habitAssigns,
            new TypeToken<List<HabitAssignDto>>(){}.getType())).thenReturn(habitAssignDtos);
        List<HabitAssignDto> actual = habitAssignService.getAllActiveHabitAssignsByUserId(1L);
        assertEquals(habitAssignDtos , actual);
    }

    @Test
    void getAllHabitAssignsByUserIdAndAcquiredStatusTest() {
        when (habitAssignRepo.findAllByUserIdAndAcquiredAndSuspendedFalse(1L,true)).thenReturn(habitAssigns);
        when (modelMapper.map(habitAssigns,
            new TypeToken<List<HabitAssignDto>>(){}.getType())).thenReturn(habitAssignDtos);
        List<HabitAssignDto> actual = habitAssignService.getAllHabitAssignsByUserIdAndAcquiredStatus(1L,true);
        assertEquals(habitAssignDtos , actual);
    }

   @Test
    void suspendHabitAssignByHabitIdAndUserIdTest() {
       when(habitAssignRepo.findByHabitIdAndUserIdAndSuspendedFalse(1L, 1L))
           .thenReturn(Optional.of(habitAssign));
       habitAssignRepo.suspendByHabitIdAndUserId(1L, 1L);
       when(modelMapper.map(habitAssignRepo.findById(habitAssign.getId()),
           HabitAssignDto.class)).thenReturn(habitAssignDto);
       assertEquals(habitAssignDto, habitAssignService.suspendHabitAssignByHabitIdAndUserId(1L, 1L));
   }

   @Test
    void suspendHabitAssignByIdTest() {
       when(habitAssignRepo.findById(1L)).thenReturn(Optional.of(habitAssign));
       habitAssignRepo.suspendById(1L);
       when (modelMapper.map(habitAssignRepo.findById(habitAssign.getId()), HabitAssignDto.class)).thenReturn(habitAssignDto);
       assertEquals(habitAssignDto, habitAssignService.suspendHabitAssignById(1L));
   }

   @Test
    void updateHabitAssignAcquiredStatusByIdTest() {
       when(habitAssignRepo.findById(1L)).thenReturn(Optional.of(habitAssign));
       habitAssignRepo.updateAcquiredById(1L,true);
       when (modelMapper.map(habitAssignRepo.findById(habitAssign.getId()), HabitAssignDto.class)).thenReturn(habitAssignDto);
       assertEquals(habitAssignDto, habitAssignService.updateHabitAssignAcquiredStatusById(1L,true));
   }

   @Test
    void deleteHabitAssignByUserIdAndHabitIdAndCreateDateTest() {
        habitStatusService.deleteStatusByHabitAssignId(habitAssign.getId());
        habitStatisticService.deleteAllStatsByHabitAssignId(habitAssign.getId());
        habitAssignRepo.deleteById(habitAssign.getId());
        verify(habitStatusService, times(1)).deleteStatusByHabitAssignId(1L);
        verify(habitStatisticService, times(1)).deleteAllStatsByHabitAssignId(1L);
        verify(habitAssignRepo, times(1)).deleteById(1L);
   }

   @Test
    void getAmountOfHabitsInProgressByUserIdTest() {
        when(habitAssignRepo.getAmountOfHabitsInProgressByUserId(1L)).thenReturn(4L);
        assertEquals(4L,habitAssignService.getAmountOfHabitsInProgressByUserId(1L));
   }

   @Test
    void getAmountOfAcquiredHabitsByUserIdTest() {
       when(habitAssignRepo.getAmountOfAcquiredHabitsByUserId(1L)).thenReturn(4L);
       assertEquals(4L,habitAssignService.getAmountOfAcquiredHabitsByUserId(1L));
   }
}