package greencity;

import com.google.maps.model.AddressComponent;
import com.google.maps.model.AddressComponentType;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;
import greencity.constant.AppConstant;
import greencity.dto.PageableAdvancedDto;
import greencity.dto.achievement.AchievementManagementDto;
import greencity.dto.achievement.AchievementPostDto;
import greencity.dto.achievement.AchievementTranslationVO;
import greencity.dto.achievement.AchievementVO;
import greencity.dto.achievement.UserAchievementVO;
import greencity.dto.achievement.UserVOAchievement;
import greencity.dto.achievementcategory.AchievementCategoryDto;
import greencity.dto.achievementcategory.AchievementCategoryVO;
import greencity.dto.advice.AdviceDto;
import greencity.dto.advice.AdvicePostDto;
import greencity.dto.advice.AdviceTranslationVO;
import greencity.dto.advice.AdviceVO;
import greencity.dto.breaktime.BreakTimeDto;
import greencity.dto.category.CategoryDto;
import greencity.dto.category.CategoryVO;
import greencity.dto.comment.AddCommentDto;
import greencity.dto.comment.CommentReturnDto;
import greencity.dto.discount.DiscountValueDto;
import greencity.dto.econews.AddEcoNewsDtoRequest;
import greencity.dto.econews.AddEcoNewsDtoResponse;
import greencity.dto.econews.EcoNewsDto;
import greencity.dto.econews.EcoNewsDtoManagement;
import greencity.dto.econews.EcoNewsGenericDto;
import greencity.dto.econews.EcoNewsVO;
import greencity.dto.econews.EcoNewsViewDto;
import greencity.dto.econews.UpdateEcoNewsDto;
import greencity.dto.econewscomment.AddEcoNewsCommentDtoRequest;
import greencity.dto.econewscomment.AddEcoNewsCommentDtoResponse;
import greencity.dto.econewscomment.EcoNewsCommentAuthorDto;
import greencity.dto.econewscomment.EcoNewsCommentDto;
import greencity.dto.econewscomment.EcoNewsCommentVO;
import greencity.dto.event.AddEventDtoRequest;
import greencity.dto.event.AddEventDtoResponse;
import greencity.dto.event.CoordinatesDto;
import greencity.dto.event.EventAttenderDto;
import greencity.dto.event.EventAuthorDto;
import greencity.dto.event.EventDateLocationDto;
import greencity.dto.event.EventDto;
import greencity.dto.event.EventVO;
import greencity.dto.event.UpdateEventDto;
import greencity.dto.eventcomment.AddEventCommentDtoRequest;
import greencity.dto.eventcomment.AddEventCommentDtoResponse;
import greencity.dto.eventcomment.EventCommentAuthorDto;
import greencity.dto.eventcomment.EventCommentDto;
import greencity.dto.eventcomment.EventCommentForSendEmailDto;
import greencity.dto.eventcomment.EventCommentVO;
import greencity.dto.factoftheday.FactOfTheDayDTO;
import greencity.dto.factoftheday.FactOfTheDayPostDTO;
import greencity.dto.factoftheday.FactOfTheDayTranslationDTO;
import greencity.dto.factoftheday.FactOfTheDayTranslationEmbeddedPostDTO;
import greencity.dto.factoftheday.FactOfTheDayTranslationVO;
import greencity.dto.factoftheday.FactOfTheDayVO;
import greencity.dto.favoriteplace.FavoritePlaceDto;
import greencity.dto.favoriteplace.FavoritePlaceVO;
import greencity.dto.habit.HabitAssignDto;
import greencity.dto.habit.HabitAssignPropertiesDto;
import greencity.dto.habit.HabitAssignUserShoppingListItemDto;
import greencity.dto.habit.HabitAssignVO;
import greencity.dto.habit.HabitDto;
import greencity.dto.habit.HabitManagementDto;
import greencity.dto.habit.HabitVO;
import greencity.dto.habit.UpdateUserShoppingListDto;
import greencity.dto.habit.UserShoppingAndCustomShoppingListsDto;
import greencity.dto.habitfact.HabitFactDto;
import greencity.dto.habitfact.HabitFactPostDto;
import greencity.dto.habitfact.HabitFactTranslationUpdateDto;
import greencity.dto.habitfact.HabitFactTranslationVO;
import greencity.dto.habitfact.HabitFactUpdateDto;
import greencity.dto.habitfact.HabitFactVO;
import greencity.dto.habitstatuscalendar.HabitStatusCalendarDto;
import greencity.dto.habitstatuscalendar.HabitStatusCalendarVO;
import greencity.dto.habittranslation.HabitTranslationDto;
import greencity.dto.language.LanguageDTO;
import greencity.dto.language.LanguageTranslationDTO;
import greencity.dto.language.LanguageVO;
import greencity.dto.location.AddPlaceLocation;
import greencity.dto.location.LocationAddressAndGeoDto;
import greencity.dto.location.LocationDto;
import greencity.dto.location.LocationVO;
import greencity.dto.openhours.OpeningHoursDto;
import greencity.dto.ownsecurity.OwnSecurityVO;
import greencity.dto.place.AddPlaceDto;
import greencity.dto.place.FilterPlaceCategory;
import greencity.dto.place.PlaceAddDto;
import greencity.dto.place.PlaceByBoundsDto;
import greencity.dto.place.PlaceResponse;
import greencity.dto.place.PlaceVO;
import greencity.dto.search.SearchNewsDto;
import greencity.dto.shoppinglistitem.CustomShoppingListItemResponseDto;
import greencity.dto.shoppinglistitem.CustomShoppingListItemVO;
import greencity.dto.shoppinglistitem.CustomShoppingListItemWithStatusSaveRequestDto;
import greencity.dto.shoppinglistitem.ShoppingListItemDto;
import greencity.dto.shoppinglistitem.ShoppingListItemWithStatusRequestDto;
import greencity.dto.socialnetwork.SocialNetworkImageVO;
import greencity.dto.socialnetwork.SocialNetworkVO;
import greencity.dto.specification.SpecificationVO;
import greencity.dto.tag.TagDto;
import greencity.dto.tag.TagPostDto;
import greencity.dto.tag.TagTranslationDto;
import greencity.dto.tag.TagTranslationVO;
import greencity.dto.tag.TagUaEnDto;
import greencity.dto.tag.TagVO;
import greencity.dto.tag.TagViewDto;
import greencity.dto.user.AuthorDto;
import greencity.dto.user.EcoNewsAuthorDto;
import greencity.dto.user.HabitIdRequestDto;
import greencity.dto.user.RecommendedFriendDto;
import greencity.dto.user.UserFilterDtoRequest;
import greencity.dto.user.UserFilterDtoResponse;
import greencity.dto.user.UserManagementVO;
import greencity.dto.user.UserProfilePictureDto;
import greencity.dto.user.UserShoppingListItemAdvanceDto;
import greencity.dto.user.UserShoppingListItemResponseDto;
import greencity.dto.user.UserShoppingListItemVO;
import greencity.dto.user.UserStatusDto;
import greencity.dto.user.UserVO;
import greencity.dto.useraction.UserActionVO;
import greencity.dto.verifyemail.VerifyEmailVO;
import greencity.entity.Achievement;
import greencity.entity.AchievementCategory;
import greencity.entity.Advice;
import greencity.entity.BreakTime;
import greencity.entity.Category;
import greencity.entity.Comment;
import greencity.entity.CustomShoppingListItem;
import greencity.entity.DiscountValue;
import greencity.entity.EcoNews;
import greencity.entity.EcoNewsComment;
import greencity.entity.FactOfTheDay;
import greencity.entity.FactOfTheDayTranslation;
import greencity.entity.FavoritePlace;
import greencity.entity.Filter;
import greencity.entity.Habit;
import greencity.entity.HabitAssign;
import greencity.entity.HabitFact;
import greencity.entity.HabitFactTranslation;
import greencity.entity.HabitStatistic;
import greencity.entity.HabitStatusCalendar;
import greencity.entity.HabitTranslation;
import greencity.entity.Language;
import greencity.entity.Location;
import greencity.entity.OpeningHours;
import greencity.entity.Photo;
import greencity.entity.Place;
import greencity.entity.ShoppingListItem;
import greencity.entity.Specification;
import greencity.entity.Tag;
import greencity.entity.User;
import greencity.entity.UserAchievement;
import greencity.entity.UserAction;
import greencity.entity.UserShoppingListItem;
import greencity.entity.VerifyEmail;
import greencity.entity.event.Coordinates;
import greencity.entity.event.Event;
import greencity.entity.event.EventComment;
import greencity.entity.event.EventDateLocation;
import greencity.entity.event.EventGrade;
import greencity.entity.localization.AchievementTranslation;
import greencity.entity.localization.AdviceTranslation;
import greencity.entity.localization.ShoppingListItemTranslation;
import greencity.entity.localization.TagTranslation;
import greencity.enums.AchievementStatus;
import greencity.enums.CommentStatus;
import greencity.enums.EmailNotification;
import greencity.enums.FactOfDayStatus;
import greencity.enums.HabitAssignStatus;
import greencity.enums.HabitRate;
import greencity.enums.PlaceStatus;
import greencity.enums.Role;
import greencity.enums.ShoppingListItemStatus;
import greencity.enums.TagType;
import greencity.enums.UserStatus;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static greencity.enums.UserStatus.ACTIVATED;

public class ModelUtils {
    public static User TEST_USER = createUser();
    public static User TEST_USER_ROLE_USER = createUserRoleUser();
    public static UserVO TEST_USER_VO = createUserVO();
    public static UserVO TEST_USER_VO_ROLE_USER = createUserVORoleUser();
    public static UserStatusDto TEST_USER_STATUS_DTO = createUserStatusDto();
    public static String TEST_EMAIL = "test@mail.com";
    public static String TEST_EMAIL_2 = "test2@mail.com";
    public static HabitAssign HABIT_ASSIGN_IN_PROGRESS = createHabitAssignInProgress();
    public static ZonedDateTime zonedDateTime = ZonedDateTime.now();
    public static LocalDateTime localDateTime = LocalDateTime.now();

    public static EventAttenderDto getEventAttenderDto() {
        return EventAttenderDto.builder().id(1L).name(TestConst.NAME).build();
    }

    public static Tag getTag() {
        return new Tag(1L, TagType.ECO_NEWS, getTagTranslations(), Collections.emptyList(),
            Collections.emptySet(), Collections.emptySet());
    }

    public static Tag getEventTag() {
        return new Tag(1L, TagType.EVENT, getEventTagTranslations(), Collections.emptyList(),
            Collections.emptySet(), Collections.emptySet());
    }

    public static List<TagTranslation> getTagTranslations() {
        return Arrays.asList(
            TagTranslation.builder().id(1L).name("Новини").language(Language.builder().id(2L).code("ua").build())
                .build(),
            TagTranslation.builder().id(2L).name("News").language(Language.builder().id(1L).code("en").build())
                .build());
    }

    public static List<TagTranslation> getEventTagTranslations() {
        Language language = getLanguage();
        return Arrays.asList(
            TagTranslation.builder().id(1L).name("Соціальний").language(getLanguageUa()).build(),
            TagTranslation.builder().id(2L).name("Social").language(language).build(),
            TagTranslation.builder().id(3L).name("Соціальний").language(language).build());
    }

    public static TagDto getTagDto() {
        return TagDto.builder().id(2L).name("News").build();
    }

    public static List<Tag> getTags() {
        return Collections.singletonList(getTag());
    }

    public static List<Tag> getEventTags() {
        return Collections.singletonList(getEventTag());
    }

    public static User getUser() {
        return User.builder()
            .id(1L)
            .email(TestConst.EMAIL)
            .name(TestConst.NAME)
            .role(Role.ROLE_USER)
            .userStatus(UserStatus.ACTIVATED)
            .lastActivityTime(localDateTime)
            .verifyEmail(new VerifyEmail())
            .dateOfRegistration(localDateTime)
            .build();
    }

    public static User getAttenderUser() {
        return User.builder()
            .id(2L)
            .email("danylo@gmail.com")
            .name("Danylo")
            .role(Role.ROLE_USER)
            .userStatus(UserStatus.ACTIVATED)
            .lastActivityTime(localDateTime)
            .verifyEmail(new VerifyEmail())
            .dateOfRegistration(localDateTime)
            .build();
    }

    public static RecommendedFriendDto getRecommendedFriendDto() {
        return new RecommendedFriendDto(1L, TestConst.NAME, "profile");
    }

    public static List<User> getFriendsList() {
        User friend1 = User.builder()
            .id(10L)
            .rating(10.0)
            .build();
        User friend2 = User.builder()
            .id(2L)
            .rating(20.0)
            .build();
        User friend3 = User.builder()
            .id(3L)
            .rating(30.0)
            .build();
        User friend4 = User.builder()
            .id(4L)
            .rating(40.0)
            .build();
        User friend5 = User.builder()
            .id(5L)
            .rating(50.0)
            .build();
        User friend6 = User.builder()
            .id(6L)
            .rating(60.0)
            .build();
        User friend7 = User.builder()
            .id(7L)
            .rating(70.0)
            .build();
        User friend8 = User.builder()
            .id(8L)
            .rating(80.0)
            .build();
        return List.of(friend1, friend2, friend3, friend4, friend5, friend6, friend7, friend8);
    }

    public static UserVO getUserVO() {
        return UserVO.builder()
            .id(1L)
            .email(TestConst.EMAIL)
            .name(TestConst.NAME)
            .role(Role.ROLE_USER)
            .lastActivityTime(localDateTime)
            .verifyEmail(new VerifyEmailVO())
            .dateOfRegistration(localDateTime)
            .build();
    }

    public static UserManagementVO getUserManagementVO() {
        return UserManagementVO.builder()
            .id(1L)
            .userStatus(ACTIVATED)
            .email("Test@gmail.com")
            .role(Role.ROLE_ADMIN).build();
    }

    public static UserVOAchievement getUserVOAchievement() {
        return UserVOAchievement.builder()
            .id(1L)
            .name(TestConst.NAME)
            .build();
    }

    public static UserVO getUserVOWithData() {
        return UserVO.builder()
            .id(13L)
            .name("user")
            .email("namesurname1995@gmail.com")
            .role(Role.ROLE_USER)
            .userCredo("save the world")
            .firstName("name")
            .emailNotification(EmailNotification.MONTHLY)
            .userStatus(UserStatus.ACTIVATED)
            .rating(13.4)
            .verifyEmail(VerifyEmailVO.builder()
                .id(32L)
                .user(UserVO.builder()
                    .id(13L)
                    .name("user")
                    .build())
                .expiryDate(LocalDateTime.of(2021, 7, 7, 7, 7))
                .token("toooookkkeeeeen42324532542")
                .build())
            .userFriends(Collections.singletonList(
                UserVO.builder()
                    .id(75L)
                    .name("Andrew")
                    .build()))
            .refreshTokenKey("refreshtoooookkkeeeeen42324532542")
            .ownSecurity(null)
            .dateOfRegistration(LocalDateTime.of(2020, 6, 6, 13, 47))
            .city("Lviv")
            .showShoppingList(true)
            .showEcoPlace(true)
            .showLocation(true)
            .socialNetworks(Collections.singletonList(
                SocialNetworkVO.builder()
                    .id(10L)
                    .user(UserVO.builder()
                        .id(13L)
                        .email("namesurname1995@gmail.com")
                        .build())
                    .url("www.network.com")
                    .socialNetworkImage(SocialNetworkImageVO.builder()
                        .id(25L)
                        .hostPath("path///")
                        .imagePath("imagepath///")
                        .build())
                    .build()))
            .ownSecurity(OwnSecurityVO.builder()
                .id(1L)
                .password("password")
                .user(UserVO.builder()
                    .id(13L)
                    .build())
                .build())
            .lastActivityTime(LocalDateTime.of(2020, 12, 11, 13, 30))
            .userAchievements(List.of(
                UserAchievementVO.builder()
                    .id(47L)
                    .achievementStatus(AchievementStatus.ACTIVE)
                    .user(UserVO.builder()
                        .id(13L)
                        .build())
                    .achievement(AchievementVO.builder()
                        .id(56L)
                        .build())
                    .build(),
                UserAchievementVO.builder()
                    .id(39L)
                    .achievementStatus(AchievementStatus.INACTIVE)
                    .user(UserVO.builder()
                        .id(13L)
                        .build())
                    .achievement(AchievementVO.builder()
                        .id(14L)
                        .build())
                    .build()))
            .userActions(Collections.singletonList(UserActionVO.builder()
                .id(13L)
                .achievementCategory(AchievementCategoryVO.builder()
                    .id(1L)
                    .build())
                .count(0)
                .user(UserVO.builder()
                    .id(13L)
                    .build())
                .build()))
            .build();
    }

    public static Language getLanguage() {
        return new Language(1L, AppConstant.DEFAULT_LANGUAGE_CODE, Collections.emptyList(), Collections.emptyList(),
            Collections.emptyList(), Collections.emptyList());
    }

    public static Language getLanguageUa() {
        return new Language(2L, "ua", Collections.emptyList(), Collections.emptyList(),
            Collections.emptyList(), Collections.emptyList());
    }

    public static EcoNews getEcoNews() {
        Tag tag = new Tag();
        tag.setTagTranslations(
            List.of(TagTranslation.builder().name("Новини").language(Language.builder().code("ua").build()).build(),
                TagTranslation.builder().name("News").language(Language.builder().code("en").build()).build()));
        return new EcoNews(1L, zonedDateTime, TestConst.SITE, "source", "shortInfo", getUser(),
            "title", "text", List.of(EcoNewsComment.builder().id(1L).text("test").build()),
            Collections.singletonList(tag), Collections.emptySet(), Collections.emptySet());
    }

    public static EcoNews getEcoNewsForMethodConvertTest() {
        Tag tag = new Tag();
        tag.setTagTranslations(
            List.of(TagTranslation.builder().name("Новини").language(Language.builder().code("ua").build()).build(),
                TagTranslation.builder().name("News").language(Language.builder().code("en").build()).build()));
        return new EcoNews(1L, ZonedDateTime.now(), TestConst.SITE, null, "shortInfo", getUser(),
            "title", "text", List.of(EcoNewsComment.builder().text("sdfs").build()),
            Collections.singletonList(tag), Collections.emptySet(), Collections.emptySet());
    }

    public static EcoNews getEcoNewsForFindDtoByIdAndLanguage() {
        return new EcoNews(1L, null, TestConst.SITE, null, "shortInfo", getUser(),
            "title", "text", null, Collections.singletonList(getTag()), Collections.emptySet(), Collections.emptySet());
    }

    public static EcoNewsVO getEcoNewsVO() {
        return new EcoNewsVO(1L, zonedDateTime, TestConst.SITE, null, getUserVO(),
            "title", "text", null, Collections.emptySet(), Collections.singletonList(getTagVO()),
            Collections.emptySet());
    }

    public static ShoppingListItemTranslation getShoppingListItemTranslation() {
        return ShoppingListItemTranslation.builder()
            .id(2L)
            .language(
                new Language(2L, AppConstant.DEFAULT_LANGUAGE_CODE, Collections.emptyList(), Collections.emptyList(),
                    Collections.emptyList(), Collections.emptyList()))
            .shoppingListItem(
                new ShoppingListItem(1L, Collections.emptyList(), Collections.emptySet(), Collections.emptyList()))
            .content("Buy a bamboo toothbrush")
            .build();
    }

    public static ShoppingListItemTranslation getShoppingListItemTranslations1() {
        return ShoppingListItemTranslation.builder()
            .id(1L)
            .language(
                new Language(1L, AppConstant.DEFAULT_LANGUAGE_CODE, Collections.emptyList(), Collections.emptyList(),
                    Collections.emptyList(), Collections.emptyList()))
            .shoppingListItem(
                new ShoppingListItem(1L, Collections.emptyList(), Collections.emptySet(), Collections.emptyList()))
            .content("Buy a bamboo toothbrush")
            .build();
    }

    public static ShoppingListItemWithStatusRequestDto getShoppingListItemWithStatusRequestDto() {
        return ShoppingListItemWithStatusRequestDto.builder()
            .id(1L)
            .status(ShoppingListItemStatus.ACTIVE)
            .build();
    }

    public static CustomShoppingListItemWithStatusSaveRequestDto getCustomShoppingListItemWithStatusSaveRequestDto() {
        return CustomShoppingListItemWithStatusSaveRequestDto.builder()
            .text("TEXT")
            .status(ShoppingListItemStatus.INPROGRESS)
            .build();
    }

    public static HabitStatusCalendarDto getHabitStatusCalendarDto() {
        return HabitStatusCalendarDto.builder()
            .enrollDate(LocalDate.now()).id(1L).build();
    }

    public static HabitStatusCalendarVO getHabitStatusCalendarVO() {
        return HabitStatusCalendarVO.builder()
            .enrollDate(LocalDate.now()).id(1L).build();
    }

    public static HabitStatusCalendar getHabitStatusCalendar() {
        return HabitStatusCalendar.builder()
            .enrollDate(LocalDate.now()).id(1L).build();
    }

    public static HabitAssignDto getHabitAssignDto() {
        return HabitAssignDto.builder()
            .id(1L)
            .status(HabitAssignStatus.ACQUIRED)
            .createDateTime(ZonedDateTime.now())
            .habit(HabitDto.builder().id(1L).build())
            .userId(1L).build();
    }

    public static HabitAssign getHabitAssign() {
        return HabitAssign.builder()
            .id(1L)
            .status(HabitAssignStatus.ACQUIRED)
            .createDate(ZonedDateTime.now())
            .habit(Habit.builder()
                .id(1L)
                .image("")
                .habitTranslations(Collections.singletonList(HabitTranslation.builder()
                    .id(1L)
                    .name("")
                    .description("")
                    .habitItem("")
                    .language(getLanguage())
                    .build()))
                .build())
            .user(getUser())
            .userShoppingListItems(new ArrayList<>())
            .workingDays(0)
            .duration(0)
            .habitStreak(0)
            .habitStatistic(Collections.singletonList(getHabitStatistic()))
            .habitStatusCalendars(Collections.singletonList(getHabitStatusCalendar()))
            .lastEnrollmentDate(ZonedDateTime.now())
            .build();
    }

    public static HabitAssign getFullHabitAssign() {
        return HabitAssign.builder()
            .id(1L)
            .status(HabitAssignStatus.ACQUIRED)
            .createDate(ZonedDateTime.now())
            .habit(Habit.builder()
                .id(1L)
                .image("")
                .habitTranslations(Collections.singletonList(HabitTranslation.builder()
                    .id(1L)
                    .name("")
                    .description("")
                    .habitItem("")
                    .language(getLanguage())
                    .build()))
                .build())
            .user(getUser())
            .userShoppingListItems(getUserShoppingListItemList())
            .workingDays(0)
            .duration(0)
            .habitStreak(0)
            .habitStatistic(Collections.singletonList(getHabitStatistic()))
            .habitStatusCalendars(Collections.singletonList(getHabitStatusCalendar()))
            .lastEnrollmentDate(ZonedDateTime.now())
            .build();
    }

    public static HabitAssignVO getHabitAssignVO() {
        return HabitAssignVO.builder()
            .id(1L)
            .habitVO(getHabitVO())
            .status(HabitAssignStatus.ACQUIRED)
            .createDateTime(ZonedDateTime.now())
            .userVO(UserVO.builder().id(1L).build()).build();
    }

    public static HabitStatistic getHabitStatistic() {
        return HabitStatistic.builder()
            .id(1L).habitRate(HabitRate.GOOD).createDate(ZonedDateTime.now())
            .amountOfItems(10).build();
    }

    public static HabitVO getHabitVO() {
        return HabitVO.builder().id(1L).image("img.png").build();
    }

    public static UserShoppingListItem getCustomUserShoppingListItem() {
        return UserShoppingListItem.builder()
            .id(1L)
            .habitAssign(HabitAssign.builder().id(1L).build())
            .status(ShoppingListItemStatus.DONE)
            .build();
    }

    public static UserShoppingListItem getFullUserShoppingListItem() {
        return UserShoppingListItem.builder()
            .id(1L)
            .shoppingListItem(getShoppingListItem())
            .habitAssign(HabitAssign.builder().id(1L).build())
            .status(ShoppingListItemStatus.DONE)
            .build();
    }

    public static List<String> getTagsForTestingString() {
        List<String> tags = new ArrayList<>();
        tags.add("News");
        return tags;
    }

    public static List<UserShoppingListItem> getUserShoppingListItemList() {
        List<UserShoppingListItem> getUserShoppingListItemList = new ArrayList();
        getUserShoppingListItemList.add(getFullUserShoppingListItem());
        getUserShoppingListItemList.add(getFullUserShoppingListItem());
        getUserShoppingListItemList.add(getFullUserShoppingListItem());

        return getUserShoppingListItemList;
    }

    public static List<ShoppingListItemTranslation> getShoppingListItemTranslationList() {
        ShoppingListItemTranslation translation = getShoppingListItemTranslations1();
        ShoppingListItemTranslation translation2 = getShoppingListItemTranslations1();
        ShoppingListItemTranslation translation3 = getShoppingListItemTranslations1();
        List<ShoppingListItemTranslation> list = new ArrayList();
        list.add(translation);
        list.add(translation2);
        list.add(translation3);
        return list;
    }

    public static UserShoppingListItemResponseDto getUserShoppingListItemResponseDto() {
        return UserShoppingListItemResponseDto.builder()
            .id(1L)
            .text("Buy electric car")
            .status(ShoppingListItemStatus.ACTIVE)
            .build();
    }

    public static UserShoppingListItem getPredefinedUserShoppingListItem() {
        return UserShoppingListItem.builder()
            .id(2L)
            .habitAssign(HabitAssign.builder().id(1L).build())
            .status(ShoppingListItemStatus.ACTIVE)
            .shoppingListItem(ShoppingListItem.builder().id(1L).userShoppingListItems(Collections.emptyList())
                .translations(
                    getShoppingListItemTranslations())
                .build())
            .build();
    }

    public static UserShoppingListItemVO getUserShoppingListItemVO() {
        return UserShoppingListItemVO.builder()
            .id(1L)
            .habitAssign(HabitAssignVO.builder()
                .id(1L)
                .build())
            .status(ShoppingListItemStatus.DONE)
            .build();
    }

    public static UserShoppingListItem getUserShoppingListItem() {
        return UserShoppingListItem.builder()
            .id(1L)
            .status(ShoppingListItemStatus.DONE)
            .habitAssign(HabitAssign.builder()
                .id(1L)
                .status(HabitAssignStatus.ACQUIRED)
                .habitStreak(10)
                .duration(300)
                .lastEnrollmentDate(ZonedDateTime.now())
                .workingDays(5)
                .build())
            .shoppingListItem(ShoppingListItem.builder()
                .id(1L)
                .build())
            .dateCompleted(LocalDateTime.of(2021, 2, 2, 14, 2))
            .build();
    }

    public static List<ShoppingListItemTranslation> getShoppingListItemTranslations() {
        return Arrays.asList(
            ShoppingListItemTranslation.builder()
                .id(2L)
                .language(new Language(1L, AppConstant.DEFAULT_LANGUAGE_CODE, Collections.emptyList(),
                    Collections.emptyList(), Collections.emptyList(), Collections.emptyList()))
                .content("Buy a bamboo toothbrush")
                .shoppingListItem(
                    new ShoppingListItem(1L, Collections.emptyList(), Collections.emptySet(), Collections.emptyList()))
                .build(),
            ShoppingListItemTranslation.builder()
                .id(11L)
                .language(new Language(1L, AppConstant.DEFAULT_LANGUAGE_CODE, Collections.emptyList(),
                    Collections.emptyList(), Collections.emptyList(), Collections.emptyList()))
                .content("Start recycling batteries")
                .shoppingListItem(
                    new ShoppingListItem(4L, Collections.emptyList(), Collections.emptySet(), Collections.emptyList()))
                .build());
    }

    public static FactOfTheDay getFactOfTheDay() {
        return new FactOfTheDay(1L, "Fact of the day",
            Collections.singletonList(ModelUtils.getFactOfTheDayTranslation()), ZonedDateTime.now());
    }

    public static FactOfTheDayDTO getFactOfTheDayDto() {
        return new FactOfTheDayDTO(1L, "name", null, ZonedDateTime.now());
    }

    public static FactOfTheDayPostDTO getFactOfTheDayPostDto() {
        return new FactOfTheDayPostDTO(1L, "name",
            Collections.singletonList(
                new FactOfTheDayTranslationEmbeddedPostDTO("content", AppConstant.DEFAULT_LANGUAGE_CODE)));
    }

    public static FactOfTheDayTranslationVO getFactOfTheDayTranslationVO() {
        return FactOfTheDayTranslationVO.builder()
            .id(1L)
            .content("Content")
            .language(LanguageVO.builder()
                .id(ModelUtils.getLanguage().getId())
                .code(ModelUtils.getLanguage().getCode())
                .build())
            .factOfTheDay(FactOfTheDayVO.builder()
                .id(ModelUtils.getFactOfTheDay().getId())
                .name(ModelUtils.getFactOfTheDay().getName())
                .createDate(ModelUtils.getFactOfTheDay().getCreateDate())
                .build())
            .build();
    }

    public static FactOfTheDayVO getFactOfTheDayVO() {
        return FactOfTheDayVO.builder()
            .id(1L)
            .name("name")
            .factOfTheDayTranslations(Collections.singletonList(ModelUtils.getFactOfTheDayTranslationVO()))
            .build();
    }

    public static FactOfTheDayTranslation getFactOfTheDayTranslation() {
        return FactOfTheDayTranslation.builder()
            .id(1L)
            .content("Content")
            .language(ModelUtils.getLanguage())
            .factOfTheDay(null)
            .build();
    }

    public static Category getCategory() {
        return Category.builder()
            .id(12L)
            .name("category")
            .build();
    }

    public static Place getPlace() {
        Place place = new Place();
        place.setLocation(new Location(1L, 49.84988, 24.022533, "вулиця Під Дубом, 7Б", "test", place));
        place.setId(1L);
        place.setName("Forum");
        place.setDescription("Shopping center");
        place.setPhone("0322 489 850");
        place.setEmail("forum_lviv@gmail.com");
        place.setAuthor(getUser());
        place.setModifiedDate(ZonedDateTime.now());
        place.setStatus(PlaceStatus.PROPOSED);
        return place;
    }

    public static PlaceVO getPlaceVO() {
        PlaceVO placeVO = new PlaceVO();
        placeVO.setId(1L);
        placeVO.setName("Forum");
        placeVO.setDescription("Shopping center");
        placeVO.setPhone("0322 489 850");
        placeVO.setEmail("forum_lviv@gmail.com");
        placeVO.setLocation(LocationVO.builder()
            .id(1L)
            .build());
        placeVO.setModifiedDate(ZonedDateTime.now());
        CategoryVO categoryVO = new CategoryVO();
        categoryVO.setName("category");
        placeVO.setCategory(categoryVO);
        return placeVO;
    }

    public static PlaceAddDto getPlaceAddDto() {
        PlaceAddDto placeAddDto = new PlaceAddDto();
        placeAddDto.setName("Test");
        CategoryDto category = new CategoryDto();
        category.setName("category");
        placeAddDto.setCategory(category);
        placeAddDto.setLocation(getLocationAddressAndGeoDto());
        HashSet<OpeningHoursDto> openingHoursDtos = new HashSet<>();
        openingHoursDtos.add(getOpeningHoursDto());
        placeAddDto.setOpeningHoursList(openingHoursDtos);
        HashSet<DiscountValueDto> discountValueDtos = new HashSet<>();
        discountValueDtos.add(getDiscountValueDto());
        placeAddDto.setDiscountValues(discountValueDtos);
        return placeAddDto;
    }

    public static HabitFactTranslation getFactTranslation() {
        return HabitFactTranslation.builder()
            .id(1L)
            .factOfDayStatus(FactOfDayStatus.CURRENT)
            .habitFact(null)
            .content("Content")
            .language(getLanguage())
            .build();
    }

    public static HabitFactTranslationVO getFactTranslationVO() {
        return HabitFactTranslationVO.builder()
            .id(1L)
            .factOfDayStatus(FactOfDayStatus.CURRENT)
            .habitFact(null)
            .language(getLanguageVO())
            .content("Content")
            .build();
    }

    public static HabitFact getHabitFact() {
        return new HabitFact(1L, Collections.singletonList(getFactTranslation()), null);
    }

    public static HabitFactVO getHabitFactVO() {
        return new HabitFactVO(1L, Collections.singletonList(getFactTranslationVO()), null);
    }

    public static LanguageTranslationDTO getLanguageTranslationDTO() {
        return new LanguageTranslationDTO(getLanguageDTO(), "content");
    }

    public static LanguageDTO getLanguageDTO() {
        return new LanguageDTO(1L, "en");
    }

    public static AddEcoNewsDtoRequest getAddEcoNewsDtoRequest() {
        return new AddEcoNewsDtoRequest("title", "text",
            Collections.singletonList("News"), "source", null, "shortInfo");
    }

    public static AddEcoNewsDtoResponse getAddEcoNewsDtoResponse() {
        return new AddEcoNewsDtoResponse(1L, "title",
            "text", "shortInfo", EcoNewsAuthorDto.builder().id(1L).name(TestConst.NAME).build(),
            ZonedDateTime.now(), TestConst.SITE, "source",
            Arrays.asList("Новини", "News"));
    }

    public static MultipartFile getFile() {
        Path path = Paths.get("src/test/resources/test.jpg");
        String name = TestConst.IMG_NAME;
        String contentType = "photo/plain";
        byte[] content = null;
        try {
            content = Files.readAllBytes(path);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return new MockMultipartFile(name,
            name, contentType, content);
    }

    public static URL getUrl() throws MalformedURLException {
        return new URL(TestConst.SITE);
    }

    public static EcoNewsAuthorDto getEcoNewsAuthorDto() {
        return new EcoNewsAuthorDto(1L, TestConst.NAME);
    }

    public static UserProfilePictureDto getUserProfilePictureDto() {
        return new UserProfilePictureDto(1L, "name", "image");
    }

    public static FactOfTheDayTranslationDTO getFactOfTheDayTranslationDTO() {
        return new FactOfTheDayTranslationDTO(1L, "content");
    }

    public static LocationAddressAndGeoDto getLocationAddressAndGeoDto() {
        return LocationAddressAndGeoDto.builder()
            .address("address")
            .lat(12.12d)
            .lng(12.12d)
            .build();
    }

    public static LocalTime getLocalTime() {
        return LocalTime.of(7, 20, 45, 342123342);
    }

    public static OpeningHoursDto getOpeningHoursDto() {
        OpeningHoursDto openingHours = new OpeningHoursDto();
        openingHours.setOpenTime(getLocalTime());
        openingHours.setCloseTime(getLocalTime());
        openingHours.setBreakTime(BreakTimeDto.builder()
            .startTime(getLocalTime())
            .endTime(getLocalTime())
            .build());
        openingHours.setWeekDay(DayOfWeek.MONDAY);
        return openingHours;
    }

    public static Photo getPhoto() {
        return Photo.builder()
            .id(1L)
            .name("photo")
            .build();
    }

    public static DiscountValue getDiscountValue() {
        return new DiscountValue(null, 33, null, null);
    }

    public static DiscountValueDto getDiscountValueDto() {
        return new DiscountValueDto(33, null);
    }

    public static List<TagTranslationVO> getTagTranslationsVO() {
        return Arrays.asList(TagTranslationVO.builder().id(1L).name("Новини")
            .languageVO(LanguageVO.builder().id(1L).code("ua").build()).build(),
            TagTranslationVO.builder().id(2L).name("News").languageVO(LanguageVO.builder().id(2L).code("en").build())
                .build());
    }

    public static List<TagTranslationVO> getEventTagTranslationsVO() {
        return Arrays.asList(TagTranslationVO.builder().id(1L).name("Соціальний")
            .languageVO(LanguageVO.builder().id(1L).code("ua").build()).build(),
            TagTranslationVO.builder().id(2L).name("Social").languageVO(LanguageVO.builder().id(2L).code("en").build())
                .build(),
            TagTranslationVO.builder().id(3L).name("Соціальний")
                .languageVO(LanguageVO.builder().id(3L).code("ru").build())
                .build());
    }

    public static LanguageVO getLanguageVO() {
        return new LanguageVO(1L, AppConstant.DEFAULT_LANGUAGE_CODE);
    }

    public static TagVO getTagVO() {
        return new TagVO(1L, TagType.ECO_NEWS, getTagTranslationsVO(), null, null, null);
    }

    public static TagVO getEventTagVO() {
        return new TagVO(1L, TagType.EVENT, getEventTagTranslationsVO(), null, null, null);
    }

    public static TagPostDto getTagPostDto() {
        return new TagPostDto(TagType.ECO_NEWS, getTagTranslationDtos());
    }

    public static List<TagTranslationDto> getTagTranslationDtos() {
        return Arrays.asList(
            TagTranslationDto.TagTranslationDtoBuilder().name("Новини")
                .language(LanguageDTO.builder().id(2L).code("ua").build()).build(),
            TagTranslationDto.TagTranslationDtoBuilder().name("News")
                .language(LanguageDTO.builder().id(1L).code("en").build()).build());
    }

    public static TagViewDto getTagViewDto() {
        return new TagViewDto("3", "ECO_NEWS", "News");
    }

    public static PageableAdvancedDto<TagVO> getPageableAdvancedDtoForTag() {
        return new PageableAdvancedDto<>(Collections.singletonList(getTagVO()),
            9, 1, 2, 1,
            true, false, false, true);
    }

    public static Specification getSpecification() {
        return Specification.builder()
            .id(1L)
            .name("specification")
            .build();
    }

    public static List<SpecificationVO> getListSpecificationVO() {
        List<SpecificationVO> listOfSpecificationVO = new ArrayList<>();
        listOfSpecificationVO.add(SpecificationVO.builder().id(1L).name("Animal").build());
        return listOfSpecificationVO;
    }

    public static List<SocialNetworkVO> getListSocialNetworkVO() {
        List<SocialNetworkVO> socialNetworkVO = new ArrayList<>();
        socialNetworkVO.add(SocialNetworkVO.builder().id(1L).url("url").build());
        return socialNetworkVO;
    }

    public static HabitFactTranslation getHabitFactTranslation() {
        return HabitFactTranslation.builder()
            .id(1L)
            .habitFact(getHabitFact())
            .factOfDayStatus(FactOfDayStatus.POTENTIAL)
            .language(getLanguage())
            .content("content")
            .build();
    }

    public static HabitFactDto getHabitFactDto() {
        return HabitFactDto.builder()
            .id(1L)
            .habit(HabitDto.builder()
                .id(1L)
                .image("")
                .habitTranslation(null)
                .build())
            .content("content")
            .build();
    }

    public static HabitFactPostDto getHabitFactPostDto() {
        return HabitFactPostDto.builder()
            .habit(HabitIdRequestDto.builder()
                .id(1L)
                .build())
            .translations(Collections.singletonList(getLanguageTranslationDTO()))
            .build();
    }

    public static AddEcoNewsCommentDtoResponse getAddEcoNewsCommentDtoResponse() {
        return AddEcoNewsCommentDtoResponse.builder()
            .id(getEcoNewsComment().getId())
            .author(getEcoNewsCommentAuthorDto())
            .text(getEcoNewsComment().getText())
            .modifiedDate(getEcoNewsComment().getModifiedDate())
            .build();
    }

    public static EcoNewsComment getEcoNewsComment() {
        return EcoNewsComment.builder()
            .id(1L)
            .text("text")
            .createdDate(LocalDateTime.now())
            .modifiedDate(LocalDateTime.now())
            .user(getUser())
            .ecoNews(getEcoNews())
            .build();
    }

    public static EcoNewsCommentVO getEcoNewsCommentVOWithData() {
        return EcoNewsCommentVO.builder()
            .id(278L)
            .user(UserVO.builder()
                .id(13L)
                .role(Role.ROLE_ADMIN)
                .name("name")
                .build())
            .modifiedDate(LocalDateTime.now())
            .text("I find this topic very useful!")
            .deleted(false)
            .currentUserLiked(true)
            .createdDate(LocalDateTime.of(2020, 11, 7, 12, 42))
            .usersLiked(new HashSet<UserVO>(Arrays.asList(
                UserVO.builder()
                    .id(76L)
                    .build(),
                UserVO.builder()
                    .id(543L)
                    .build(),
                UserVO.builder()
                    .id(349L)
                    .build())))
            .ecoNews(EcoNewsVO.builder()
                .id(32L)
                .build())
            .build();
    }

    public static EcoNewsCommentAuthorDto getEcoNewsCommentAuthorDto() {
        return EcoNewsCommentAuthorDto.builder()
            .id(getUser().getId())
            .name(getUser().getName().trim())
            .userProfilePicturePath(getUser().getProfilePicturePath())
            .build();
    }

    public static AddEcoNewsCommentDtoRequest getAddEcoNewsCommentDtoRequest() {
        return new AddEcoNewsCommentDtoRequest("text", 0L);
    }

    public static EcoNewsCommentDto getEcoNewsCommentDto() {
        return EcoNewsCommentDto.builder()
            .id(1L)
            .modifiedDate(LocalDateTime.now())
            .author(getEcoNewsCommentAuthorDto())
            .text("text")
            .replies(0)
            .likes(0)
            .currentUserLiked(false)
            .status(CommentStatus.ORIGINAL)
            .build();
    }

    private static AuthorDto getAuthorDto() {
        return AuthorDto.builder()
            .id(1L)
            .name("author")
            .build();
    }

    public static PlaceByBoundsDto getPlaceByBoundsDtoForFindAllTest() {
        return PlaceByBoundsDto.builder()
            .id(1L)
            .name("Ekotel")
            .location(LocationDto.builder()
                .id(12L)
                .lat(49.80)
                .lng(24.03)
                .address("Some adress")
                .build())
            .build();
    }

    public static FavoritePlaceDto getFavoritePlaceDto() {
        return new FavoritePlaceDto("name", 3L);
    }

    public static FavoritePlace getFavoritePlace() {
        return new FavoritePlace(3L, "name", getUser(), getPlace());
    }

    public static FavoritePlaceVO getFavoritePlaceVO() {
        return new FavoritePlaceVO(3L, "name", getUserVO(), getPlaceVO());
    }

    public static Comment getComment() {
        return new Comment(1L, "text", getUser(),
            getPlace(), null, null, Collections.emptyList(), null, null, null);
    }

    public static CommentReturnDto getCommentReturnDto() {
        return new CommentReturnDto(1L, "text", null, null, null);
    }

    public static AddCommentDto getAddCommentDto() {
        return new AddCommentDto("comment", null, null);
    }

    public static AdviceTranslation getAdviceTranslation() {
        return AdviceTranslation.builder()
            .id(1L)
            .language(getLanguage())
            .content("Text content")
            .advice(getAdvice())
            .build();
    }

    public static OpeningHours getOpeningHours() {
        OpeningHours openingHoursTest = new OpeningHours();
        openingHoursTest.setOpenTime(getLocalTime());
        openingHoursTest.setCloseTime(getLocalTime());
        openingHoursTest.setBreakTime(BreakTime.builder()
            .startTime(getLocalTime())
            .endTime(getLocalTime())
            .build());
        openingHoursTest.setWeekDay(DayOfWeek.MONDAY);
        return openingHoursTest;
    }

    public static Location getLocation() {
        return Location.builder()
            .address("address")
            .addressUa("test")
            .lng(12.12d)
            .lat(12.12d)
            .build();
    }

    public static HabitFactUpdateDto getHabitFactUpdateDto() {
        return HabitFactUpdateDto.builder()
            .habit(HabitIdRequestDto.builder()
                .id(1L)
                .build())
            .translations(getHabitFactTranslationUpdateDtos())
            .build();
    }

    public static AdviceDto getAdviceDto() {
        return AdviceDto.builder()
            .id(1L)
            .content("name")
            .habit(getHabitDto())
            .build();
    }

    public static List<HabitFactTranslationUpdateDto> getHabitFactTranslationUpdateDtos() {
        return new ArrayList<>(Arrays.asList(
            HabitFactTranslationUpdateDto.builder().content("ua").factOfDayStatus(FactOfDayStatus.POTENTIAL)
                .language(getLanguageDTO()).build(),
            HabitFactTranslationUpdateDto.builder().content("en").factOfDayStatus(FactOfDayStatus.POTENTIAL)
                .language(getLanguageDTO()).build(),
            HabitFactTranslationUpdateDto.builder().content("ru").factOfDayStatus(FactOfDayStatus.POTENTIAL)
                .language(getLanguageDTO()).build()));
    }

    public static List<AdviceTranslation> getAdviceTranslations() {
        Language defaultLanguage = getLanguage();
        return new ArrayList<>(Arrays.asList(
            AdviceTranslation.builder().id(1L).language(defaultLanguage).content("hello").build(),
            AdviceTranslation.builder().id(2L).language(defaultLanguage).content("text").build(),
            AdviceTranslation.builder().id(3L).language(defaultLanguage).content("smile").build()));
    }

    public static List<AdviceTranslationVO> getAdviceTranslationVOs() {
        LanguageVO defaultLanguage = getLanguageVO();
        return new ArrayList<>(Arrays.asList(
            AdviceTranslationVO.builder().id(1L).language(defaultLanguage).content("hello").build(),
            AdviceTranslationVO.builder().id(2L).language(defaultLanguage).content("text").build(),
            AdviceTranslationVO.builder().id(3L).language(defaultLanguage).content("smile").build()));
    }

    public static List<LanguageTranslationDTO> getLanguageTranslationsDTOs() {
        return Arrays.asList(
            new LanguageTranslationDTO(new LanguageDTO(1L, "en"), "hello"),
            new LanguageTranslationDTO(new LanguageDTO(1L, "en"), "text"),
            new LanguageTranslationDTO(new LanguageDTO(1L, "en"), "smile"));
    }

    public static List<Advice> getAdvices() {
        List<AdviceTranslation> adviceTranslations = getAdviceTranslations();
        return new ArrayList<>(Arrays.asList(
            Advice.builder().id(1L).habit(Habit.builder().id(1L).build())
                .translations(adviceTranslations).build(),
            Advice.builder().id(2L).habit(Habit.builder().id(1L).build()).translations(adviceTranslations).build(),
            Advice.builder().id(3L).habit(Habit.builder().id(1L).build()).translations(adviceTranslations).build()));
    }

    public static List<AdviceVO> getAdviceVOs() {
        List<AdviceTranslationVO> adviceTranslationVOs = getAdviceTranslationVOs();
        return new ArrayList<>(Arrays.asList(
            AdviceVO.builder().id(1L).habit(new HabitIdRequestDto(1L)).translations(adviceTranslationVOs).build(),
            AdviceVO.builder().id(2L).habit(new HabitIdRequestDto(1L)).translations(adviceTranslationVOs).build(),
            AdviceVO.builder().id(3L).habit(new HabitIdRequestDto(1L)).translations(adviceTranslationVOs).build()));
    }

    public static Habit getHabit() {
        return Habit.builder().id(1L).image("image.png")
            .complexity(1).tags(new HashSet<>(getTags())).build();
    }

    public static HabitTranslation getHabitTranslation() {
        return HabitTranslation.builder()
            .id(1L)
            .description("test description")
            .habitItem("test habit item")
            .language(getLanguage())
            .name("test name")
            .habit(getHabit())
            .build();
    }

    public static HabitManagementDto gethabitManagementDto() {
        return HabitManagementDto.builder()
            .id(1L)
            .image("image")
            .habitTranslations(null)
            .build();
    }

    public static Advice getAdvice() {
        return Advice.builder().id(1L)
            .translations(getAdviceTranslations())
            .habit(getHabit())
            .build();
    }

    public static AdviceVO getAdviceVO() {
        return AdviceVO.builder().id(1L)
            .translations(getAdviceTranslationVOs())
            .habit(new HabitIdRequestDto(1L))
            .build();
    }

    public static AdvicePostDto getAdvicePostDto() {
        return new AdvicePostDto(getLanguageTranslationsDTOs(), new HabitIdRequestDto(1L));
    }

    public static Achievement getAchievement() {
        return new Achievement(1L, Collections.singletonList(getAchievementTranslation()), Collections.emptyList(),
            new AchievementCategory(), 1);
    }

    public static AchievementCategory getAchievementCategory() {
        return new AchievementCategory(1L, "Name", null, null);
    }

    public static AchievementVO getAchievementVO() {
        return new AchievementVO(1L, Collections.emptyList(), Collections.emptyList(), new AchievementCategoryVO(), 1);
    }

    public static AchievementPostDto getAchievementPostDto() {
        return new AchievementPostDto(Collections.emptyList(), getAchievementCategoryDto(), 1);
    }

    public static AchievementCategoryDto getAchievementCategoryDto() {
        return new AchievementCategoryDto("Test");
    }

    public static AchievementTranslationVO getAchievementTranslationVO() {
        return new AchievementTranslationVO(1L, getLanguageVO(), "Title", "Description", "Message");
    }

    public static AchievementCategoryVO getAchievementCategoryVO() {
        return new AchievementCategoryVO(1L, "Category", null, null);
    }

    public static AchievementManagementDto getAchievementManagementDto() {
        return new AchievementManagementDto(1L);
    }

    public static AchievementTranslation getAchievementTranslation() {
        return new AchievementTranslation(1L, getLanguage(), "Title", "Description", "Message", null);
    }

    public static UserAchievementVO getUserAchievementVO() {
        return new UserAchievementVO(1L, getUserVO(), getAchievementVO(), AchievementStatus.ACTIVE);
    }

    public static UserAchievement getUserAchievement() {
        return new UserAchievement(1L, getUser(), getAchievement(), AchievementStatus.ACTIVE, false);
    }

    public static UserAction getUserAction() {
        return new UserAction(1L, ModelUtils.getUser(), ModelUtils.getAchievementCategory(), 0);
    }

    public static UserActionVO getUserActionVO() {
        return new UserActionVO(1L, ModelUtils.getUserVO(), ModelUtils.getAchievementCategoryVO(), 0);
    }

    public static EcoNewsDto getEcoNewsDto() {
        return new EcoNewsDto(ZonedDateTime.now(), "imagePath", 1L, "title", "content", "text",
            getEcoNewsAuthorDto(), Collections.singletonList("tag"), Collections.singletonList("тег"), 1, 0, 0);
    }

    public static EcoNewsGenericDto getEcoNewsGenericDto() {
        String[] tagsEn = {"News"};
        String[] tagsUa = {"Новини"};
        return new EcoNewsGenericDto(1L, "title", "text", "shortInfo",
            ModelUtils.getEcoNewsAuthorDto(), zonedDateTime, "https://google.com/", "source",
            List.of(tagsUa), List.of(tagsEn), 0, 1, 0);
    }

    public static EcoNewsDto getEcoNewsDtoForFindDtoByIdAndLanguage() {
        return new EcoNewsDto(null, TestConst.SITE, 1L, "title", "text", "shortInfo",
            getEcoNewsAuthorDto(), Collections.singletonList("News"), Collections.singletonList("Новини"), 0, 0, 0);
    }

    public static UpdateEcoNewsDto getUpdateEcoNewsDto() {
        return new UpdateEcoNewsDto(1L, "title", "text", "shortInfo", Collections.singletonList("tag"),
            "image", "source");
    }

    public static SearchNewsDto getSearchNewsDto() {
        return new SearchNewsDto(1L, "title", getEcoNewsAuthorDto(), ZonedDateTime.now(),
            Collections.singletonList("tag"));
    }

    public static EcoNewsCommentVO getEcoNewsCommentVO() {
        return new EcoNewsCommentVO(1L, "text", LocalDateTime.now(), LocalDateTime.now(), new EcoNewsCommentVO(),
            new ArrayList<>(), getUserVO(), getEcoNewsVO(), false,
            false, new HashSet<>());
    }

    public static EcoNewsDtoManagement getEcoNewsDtoManagement() {
        return new EcoNewsDtoManagement(1L, "title", "text", ZonedDateTime.now(),
            Collections.singletonList("tag"), "imagePath", "source");
    }

    public static EcoNewsViewDto getEcoNewsViewDto() {
        return new EcoNewsViewDto("1", "title", "author", "text", "startDate",
            "endDate", "tag");
    }

    public static HabitDto getHabitDto() {
        return HabitDto.builder()
            .id(1L)
            .image("image")
            .habitTranslation(new HabitTranslationDto())
            .defaultDuration(1)
            .tags(new ArrayList<>())
            .build();
    }

    public static ShoppingListItem getShoppingListItem() {
        return ShoppingListItem.builder()
            .id(1L)
            .translations(getShoppingListItemTranslations())
            .build();
    }

    public static HabitAssignPropertiesDto getHabitAssignPropertiesDto() {
        return HabitAssignPropertiesDto.builder()
            .defaultShoppingListItems(List.of(1L))
            .duration(20)
            .build();
    }

    public static HabitAssign getHabitAssignWithUserShoppingListItem() {
        return HabitAssign.builder()
            .id(1L)
            .user(User.builder().id(21L).build())
            .habit(Habit.builder().id(1L).build())
            .status(HabitAssignStatus.INPROGRESS)
            .workingDays(0)
            .duration(20)
            .userShoppingListItems(List.of(UserShoppingListItem.builder()
                .id(1L)
                .shoppingListItem(ShoppingListItem.builder().id(1L).build())
                .status(ShoppingListItemStatus.INPROGRESS)
                .build()))
            .build();
    }

    public static HabitAssignUserShoppingListItemDto getHabitAssignUserShoppingListItemDto() {
        return HabitAssignUserShoppingListItemDto.builder()
            .habitAssignId(1L)
            .userId(21L)
            .habitId(1L)
            .status(HabitAssignStatus.INPROGRESS)
            .workingDays(0)
            .duration(20)
            .userShoppingListItemsDto(List.of(UserShoppingListItemAdvanceDto.builder()
                .id(1L)
                .shoppingListItemId(1L)
                .status(ShoppingListItemStatus.INPROGRESS)
                .build()))
            .build();
    }

    public static UpdateUserShoppingListDto getUpdateUserShoppingListDto() {
        return UpdateUserShoppingListDto.builder()
            .userShoppingListItemId(1L)
            .habitAssignId(1L)
            .userShoppingListAdvanceDto(List.of(UserShoppingListItemAdvanceDto.builder()
                .id(1L)
                .shoppingListItemId(1L)
                .status(ShoppingListItemStatus.INPROGRESS)
                .build()))
            .build();
    }

    public static HabitAssignDto getFullHabitAssignDto() {
        return HabitAssignDto.builder()
            .id(1L)
            .status(HabitAssignStatus.ACQUIRED)
            .createDateTime(ZonedDateTime.of(1, 1, 1, 1, 1, 1, 1, ZoneOffset.systemDefault()))
            .habit(HabitDto.builder().id(1L).build())
            .userId(1L)
            .duration(null)
            .userShoppingListItems(List.of(UserShoppingListItemAdvanceDto.builder()
                .id(1L)
                .shoppingListItemId(1L)
                .status(ShoppingListItemStatus.INPROGRESS)
                .build()))
            .habitStatusCalendarDtoList(List.of(getHabitStatusCalendarDto()))
            .habitStreak(1)
            .lastEnrollmentDate(ZonedDateTime.of(1, 1, 1, 1, 1, 1, 1, ZoneOffset.systemDefault()))
            .workingDays(1)
            .build();
    }

    public static HabitAssign getHabitAssignForMapper() {
        return HabitAssign.builder()
            .id(1L)
            .status(HabitAssignStatus.ACQUIRED)
            .createDate(ZonedDateTime.of(1, 1, 1, 1, 1, 1, 1, ZoneOffset.systemDefault()))
            .habit(Habit.builder()
                .id(1L)
                .image(null)
                .habitTranslations(null)
                .build())
            .user(null)
            .userShoppingListItems(List.of(UserShoppingListItem.builder()
                .id(1L)
                .habitAssign(null)
                .shoppingListItem(ShoppingListItem.builder()
                    .id(1L)
                    .habits(null)
                    .translations(null)
                    .build())
                .build()))
            .workingDays(1)
            .duration(null)
            .habitStreak(1)
            .habitStatistic(null)
            .habitStatusCalendars(null)
            .lastEnrollmentDate(ZonedDateTime.of(1, 1, 1, 1, 1, 1, 1, ZoneOffset.systemDefault()))
            .build();
    }

    private static UserStatusDto createUserStatusDto() {
        return UserStatusDto.builder()
            .id(2L)
            .userStatus(UserStatus.CREATED)
            .build();
    }

    private static User createUserRoleUser() {
        return User.builder()
            .id(2L)
            .role(Role.ROLE_USER)
            .email("test2@mail.com")
            .build();
    }

    private static UserVO createUserVORoleUser() {
        return UserVO.builder()
            .id(2L)
            .role(Role.ROLE_USER)
            .email("test2@mail.com")
            .build();
    }

    private static User createUser() {
        return User.builder()
            .id(1L)
            .role(Role.ROLE_MODERATOR)
            .email("test@mail.com")
            .build();
    }

    private static UserVO createUserVO() {
        return UserVO.builder()
            .id(1L)
            .role(Role.ROLE_MODERATOR)
            .email("test@mail.com")
            .build();
    }

    private static HabitAssign createHabitAssignInProgress() {
        return HabitAssign.builder()
            .habit(Habit.builder().id(1L).build())
            .status(HabitAssignStatus.INPROGRESS)
            .build();
    }

    public static List<UserShoppingListItemVO> getUserShoppingListItemVOList() {
        List<UserShoppingListItemVO> list = new ArrayList<>();
        list.add(UserShoppingListItemVO.builder()
            .id(1L)
            .build());
        return list;
    }

    public static List<CustomShoppingListItemVO> getCustomShoppingListItemVOList() {
        List<CustomShoppingListItemVO> list = new ArrayList<>();
        list.add(CustomShoppingListItemVO.builder()
            .id(1L)
            .text("text")
            .build());
        return list;
    }

    public static UserVO createUserVO2() {
        return UserVO.builder()
            .id(1L)
            .name("name")
            .email("test@mail.com")
            .role(Role.ROLE_MODERATOR)
            .userCredo("fdsfs")
            .userStatus(UserStatus.ACTIVATED)
            .userShoppingListItemVOS(getUserShoppingListItemVOList())
            .customShoppingListItemVOS(getCustomShoppingListItemVOList())
            .rating(13.4)
            .verifyEmail(VerifyEmailVO.builder()
                .id(1L)
                .user(UserVO.builder()
                    .id(1L)
                    .name("name")
                    .email("test@mail.com")
                    .role(Role.ROLE_MODERATOR)
                    .userCredo("fdsfs")
                    .userStatus(UserStatus.ACTIVATED)
                    .userShoppingListItemVOS(getUserShoppingListItemVOList())
                    .customShoppingListItemVOS(getCustomShoppingListItemVOList())
                    .rating(13.4)
                    .emailNotification(EmailNotification.MONTHLY)
                    .dateOfRegistration(LocalDateTime.now())
                    .socialNetworks(Collections.singletonList(
                        SocialNetworkVO.builder()
                            .id(10L)
                            .user(UserVO.builder()
                                .id(1L)
                                .email("namesurname1995@gmail.com")
                                .build())
                            .url("www.network.com")
                            .socialNetworkImage(SocialNetworkImageVO.builder()
                                .id(25L)
                                .hostPath("path///")
                                .imagePath("imagepath///")
                                .build())
                            .build()))
                    .userFriends(Collections.singletonList(
                        UserVO.builder()
                            .id(75L)
                            .name("Andrew")
                            .build()))
                    .userAchievements(List.of(
                        UserAchievementVO.builder()
                            .id(47L)
                            .achievementStatus(AchievementStatus.ACTIVE)
                            .user(UserVO.builder()
                                .id(1L)
                                .build())
                            .achievement(AchievementVO.builder()
                                .id(56L)
                                .build())
                            .build(),
                        UserAchievementVO.builder()
                            .id(39L)
                            .achievementStatus(AchievementStatus.INACTIVE)
                            .user(UserVO.builder()
                                .id(1L)
                                .build())
                            .achievement(AchievementVO.builder()
                                .id(14L)
                                .build())
                            .build()))
                    .refreshTokenKey("fsdfsfd")
                    .ownSecurity(OwnSecurityVO.builder()
                        .id(1L)
                        .password("password")
                        .user(UserVO.builder()
                            .id(1L)
                            .build())
                        .build())
                    .profilePicturePath("../")
                    .ecoNewsLiked(null)
                    .ecoNewsCommentsLiked(null)
                    .firstName("dfsfsdf")
                    .city("fdsfsdf")
                    .showLocation(true)
                    .showEcoPlace(true)
                    .showShoppingList(true)
                    .lastActivityTime(LocalDateTime.now())
                    .userActions(null)
                    .languageVO(getLanguageVO())
                    .build())
                .expiryDate(LocalDateTime.of(2021, 7, 7, 7, 7))
                .token("toooookkkeeeeen42324532542")
//                        .rating(13.4)
//                        .em
                .build())
            .userFriends(Collections.singletonList(
                UserVO.builder()
                    .id(75L)
                    .name("Andrew")
                    .build()))
            .refreshTokenKey("refreshtoooookkkeeeeen42324532542")
            .ownSecurity(null)
            .dateOfRegistration(LocalDateTime.of(2020, 6, 6, 13, 47))
            .city("Lviv")
            .showShoppingList(true)
            .showEcoPlace(true)
            .showLocation(true)
            .socialNetworks(Collections.singletonList(
                SocialNetworkVO.builder()
                    .id(10L)
                    .user(UserVO.builder()
                        .id(1L)
                        .email("namesurname1995@gmail.com")
                        .build())
                    .url("www.network.com")
                    .socialNetworkImage(SocialNetworkImageVO.builder()
                        .id(25L)
                        .hostPath("path///")
                        .imagePath("imagepath///")
                        .build())
                    .build()))
            .ownSecurity(OwnSecurityVO.builder()
                .id(1L)
                .password("password")
                .user(UserVO.builder()
                    .id(1L)
                    .build())
                .build())
            .lastActivityTime(LocalDateTime.of(2020, 12, 11, 13, 30))
            .userAchievements(List.of(
                UserAchievementVO.builder()
                    .id(47L)
                    .achievementStatus(AchievementStatus.ACTIVE)
                    .user(UserVO.builder()
                        .id(1L)
                        .build())
                    .achievement(AchievementVO.builder()
                        .id(56L)
                        .build())
                    .build(),
                UserAchievementVO.builder()
                    .id(39L)
                    .achievementStatus(AchievementStatus.INACTIVE)
                    .user(UserVO.builder()
                        .id(1L)
                        .build())
                    .achievement(AchievementVO.builder()
                        .id(14L)
                        .build())
                    .build()))
            .userActions(Collections.singletonList(UserActionVO.builder()
                .id(1L)
                .achievementCategory(AchievementCategoryVO.builder()
                    .id(1L)
                    .build())
                .count(0)
                .user(UserVO.builder()
                    .id(1L)
                    .build())
                .build()))
            .build();
    }

    public static HabitAssign buildHabitAssign() {
        return HabitAssign.builder()
            .habit(getHabit())
            .status(HabitAssignStatus.INPROGRESS)
            .createDate(ZonedDateTime.now())
            .user(getUser())
            .duration(1)
            .habitStreak(0)
            .workingDays(0)
            .lastEnrollmentDate(ZonedDateTime.now())
            .build();
    }

    public static CustomShoppingListItemResponseDto getCustomShoppingListItemResponseDto() {
        return CustomShoppingListItemResponseDto.builder()
            .id(1L)
            .status(ShoppingListItemStatus.INPROGRESS)
            .text("TEXT")
            .build();
    }

    public static CustomShoppingListItem getCustomShoppingListItem() {
        return CustomShoppingListItem.builder()
            .id(1L)
            .status(ShoppingListItemStatus.INPROGRESS)
            .text("TEXT")
            .build();
    }

    public static Event getEvent() {
        Event event = new Event();
        event.setDescription("Description");
        event.setId(1L);
        event.setOrganizer(getUser());
        event.setTitle("Title");
        List<EventDateLocation> dates = new ArrayList<>();
        dates.add(new EventDateLocation(1L, event,
            ZonedDateTime.of(2098, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2099, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        dates.add(new EventDateLocation(2L, event,
            ZonedDateTime.of(2099, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2100, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        event.setDates(dates);
        event.setTags(List.of(getEventTag()));
        event.setTitleImage(AppConstant.DEFAULT_HABIT_IMAGE);
        return event;
    }

    public static Event getEventWithFinishedDate() {
        Event event = new Event();
        event.setDescription("Description");
        event.setId(1L);
        event.setOrganizer(getUser());
        event.setTitle("Title");
        List<EventDateLocation> dates = new ArrayList<>();
        dates.add(new EventDateLocation(1L, event,
            ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2001, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        event.setDates(dates);
        event.setTags(List.of(getEventTag()));
        event.setTitleImage(AppConstant.DEFAULT_HABIT_IMAGE);
        return event;
    }

    public static Event getSecondEvent() {
        Event event = new Event();
        event.setDescription("Description2");
        event.setId(2L);
        event.setOrganizer(getAttenderUser());
        event.setTitle("Title2");
        List<EventDateLocation> dates = new ArrayList<>();
        dates.add(new EventDateLocation(1L, event,
            ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        dates.add(new EventDateLocation(2L, event,
            ZonedDateTime.of(2002, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2002, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        event.setDates(dates);
        event.setTags(List.of(getEventTag()));
        event.setTitleImage(AppConstant.DEFAULT_HABIT_IMAGE);
        return event;
    }

    public static Event getUnfinishedEvent() {
        Event event = new Event();
        event.setDescription("Description");
        event.setId(1L);
        event.setOrganizer(getUser());
        event.setTitle("Title");
        List<EventDateLocation> dates = new ArrayList<>();
        dates.add(new EventDateLocation(1L, event,
            ZonedDateTime.now().plusDays(1),
            ZonedDateTime.now().plusDays(1).plusSeconds(1),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        event.setDates(dates);
        event.setTags(List.of(getEventTag()));
        event.setTitleImage(AppConstant.DEFAULT_HABIT_IMAGE);
        return event;
    }

    public static Event getEventWithoutCoordinates() {
        Event event = new Event();

        event.setDescription("Description");
        event.setId(1L);
        event.setOrganizer(getUser());
        event.setTitle("Title");
        List<EventDateLocation> dates = new ArrayList<>();
        dates.add(new EventDateLocation(1L, event,
            ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        dates.add(new EventDateLocation(2L, event,
            ZonedDateTime.of(2002, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2002, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        event.setDates(dates);
        event.setTags(List.of(getEventTag()));
        return event;
    }

    public static AddEventDtoResponse getAddEventDtoResponse() {
        return AddEventDtoResponse.builder()
            .id(1L)
            .dates(new ArrayList<>())
            .title("Title")
            .description("Description")
            .organizer(EventAuthorDto.builder()
                .id(1L)
                .name("User")
                .build())
            .build();
    }

    public static MultipartFile getMultipartFile() {
        return new MockMultipartFile("firstFile.tmp", "Hello World".getBytes());
    }

    public static MultipartFile[] getMultipartFiles() {
        return new MultipartFile[] {new MockMultipartFile("firstFile.tmp", "Hello World".getBytes()),
            new MockMultipartFile("secondFile.tmp", "Hello World".getBytes())};
    }

    public static AddEventDtoRequest addEventDtoRequest = AddEventDtoRequest.builder()
        .datesLocations(List.of(new EventDateLocationDto(1L, null,
            ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            "/url",
            CoordinatesDto.builder().build())))
        .description("Description")
        .title("Title")
        .tags(List.of("Social"))
        .build();

    public static AddEventDtoResponse addEventDtoWithoutCoordinatesResponse = AddEventDtoResponse.builder()
        .dates(List.of(new EventDateLocationDto(1L, null,
            ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            "/url",
            CoordinatesDto.builder().build()

        )))
        .description("Description")
        .title("Title")
        .build();

    public static AddEventDtoRequest addEventDtoWithoutCoordinatesRequest = AddEventDtoRequest.builder()
        .datesLocations(List.of(new EventDateLocationDto(1L, null,
            ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            "/url",
            CoordinatesDto.builder().build())))
        .description("Description")
        .title("Title")
        .build();

    public static EventDto getEventDto() {
        return EventDto.builder()
            .id(1L)
            .description("Description")
            .organizer(EventAuthorDto.builder()
                .name("User")
                .id(1L)
                .build())
            .title("Title")
            .dates(List.of(new EventDateLocationDto(1L, null,
                ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
                ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
                "/url",
                CoordinatesDto.builder().build())))
            .tags(List.of(TagUaEnDto.builder().id(1L).nameEn("Social")
                .nameUa("Соціальний").build()))
            .build();
    }

    public static EventDto getSecondEventDto() {
        return EventDto.builder()
            .id(2L)
            .description("Description2")
            .organizer(EventAuthorDto.builder()
                .name("User2")
                .id(2L)
                .build())
            .title("Title2")
            .dates(List.of(new EventDateLocationDto(1L, null,
                ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
                ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
                "/url",
                CoordinatesDto.builder().build())))
            .tags(List.of(TagUaEnDto.builder().id(1L).nameEn("Social")
                .nameUa("Соціальний").build()))
            .build();
    }

    public static EventDto getEventWithoutCoordinatesDto() {
        return EventDto.builder()
            .id(1L)
            .description("Description")
            .organizer(EventAuthorDto.builder()
                .name("User")
                .id(1L)
                .build())
            .title("Title")
            .dates(List.of(new EventDateLocationDto(1L, null,
                ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
                ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
                "/url",
                CoordinatesDto.builder().build())))
            .tags(List.of(TagUaEnDto.builder().id(1L).nameEn("Social")
                .nameUa("Соціальний").build()))
            .build();
    }

    public static FilterPlaceCategory getFilterPlaceCategory() {
        return FilterPlaceCategory.builder()
            .name("category")
            .nameUa("Категорії")
            .build();
    }

    public static AddPlaceDto getAddPlaceDto() {
        return AddPlaceDto.builder()
            .categoryName("category")
            .placeName("test")
            .locationName("Test")
            .openingHoursList(Set.of(OpeningHoursDto.builder()
                .openTime(LocalTime.now())
                .closeTime(LocalTime.now())
                .weekDay(DayOfWeek.MONDAY)
                .build()))
            .build();
    }

    public static PlaceResponse getPlaceResponse() {
        return PlaceResponse.builder()
            .category(CategoryDto.builder()
                .name("category")
                .nameUa("Test")
                .build())
            .locationAddressAndGeoDto(AddPlaceLocation.builder()
                .lng(32.2)
                .lat(32.3)
                .addressEng("test")
                .address("test")
                .build())
            .openingHoursList(Set.of(OpeningHoursDto.builder()
                .weekDay(DayOfWeek.MONDAY)
                .openTime(LocalTime.now())
                .closeTime(LocalTime.now())
                .build()))
            .build();
    }

    public static List<GeocodingResult> getGeocodingResult() {
        List<GeocodingResult> geocodingResults = new ArrayList<>();

        GeocodingResult geocodingResult1 = new GeocodingResult();

        Geometry geometry = new Geometry();
        geometry.location = new LatLng(50.5555555d, 50.5555555d);

        AddressComponent locality = new AddressComponent();
        locality.longName = "fake street";
        locality.types = new AddressComponentType[] {AddressComponentType.LOCALITY};

        AddressComponent streetNumber = new AddressComponent();
        streetNumber.longName = "13";
        streetNumber.types = new AddressComponentType[] {AddressComponentType.STREET_NUMBER};

        AddressComponent region = new AddressComponent();
        region.longName = "fake region";
        region.types = new AddressComponentType[] {AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1};

        AddressComponent sublocality = new AddressComponent();
        sublocality.longName = "fake district";
        sublocality.types = new AddressComponentType[] {AddressComponentType.SUBLOCALITY};

        AddressComponent route = new AddressComponent();
        route.longName = "fake street name";
        route.types = new AddressComponentType[] {AddressComponentType.ROUTE};

        geocodingResult1.addressComponents = new AddressComponent[] {
            locality,
            streetNumber,
            region,
            sublocality,
            route
        };

        geocodingResult1.formattedAddress = "fake address";
        geocodingResult1.geometry = geometry;

        GeocodingResult geocodingResult2 = new GeocodingResult();

        AddressComponent locality2 = new AddressComponent();
        locality2.longName = "fake street";
        locality2.types = new AddressComponentType[] {AddressComponentType.LOCALITY};

        AddressComponent streetNumber2 = new AddressComponent();
        streetNumber2.longName = "13";
        streetNumber2.types = new AddressComponentType[] {AddressComponentType.STREET_NUMBER};

        AddressComponent region2 = new AddressComponent();
        region2.longName = "fake region";
        region2.types = new AddressComponentType[] {AddressComponentType.ADMINISTRATIVE_AREA_LEVEL_1};

        AddressComponent sublocality2 = new AddressComponent();
        sublocality2.longName = "fake district";
        sublocality2.types = new AddressComponentType[] {AddressComponentType.SUBLOCALITY};

        AddressComponent route2 = new AddressComponent();
        route2.longName = "fake street name";
        route2.types = new AddressComponentType[] {AddressComponentType.ROUTE};

        geocodingResult2.addressComponents = new AddressComponent[] {
            locality2,
            streetNumber2,
            region2,
            sublocality2,
            route2
        };

        geocodingResult2.formattedAddress = "fake address 2";
        geocodingResult2.geometry = geometry;

        geocodingResults.add(geocodingResult1);
        geocodingResults.add(geocodingResult2);

        return geocodingResults;
    }

    public static AddPlaceLocation getAddPlaceLocation() {
        return AddPlaceLocation.builder()
            .address("test")
            .addressEng("address")
            .lat(12.12)
            .lng(12.12)
            .build();
    }

    public static Event getExpectedEvent() {
        Event event = new Event();
        event.setDescription("Description");
        event.setId(1L);
        event.setOrganizer(getUser());
        event.setTitle("Title");
        List<EventDateLocation> dates = new ArrayList<>();
        dates.add(new EventDateLocation(1L, event,
            ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        dates.add(new EventDateLocation(2L, event,
            ZonedDateTime.of(2002, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2002, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        event.setDates(dates);
        event.setTags(List.of(getEventTag()));
        event.setTitleImage(AppConstant.DEFAULT_HABIT_IMAGE);
        return event;
    }

    public static UpdateEventDto getUpdateEventDto() {
        UpdateEventDto updateEventDto = new UpdateEventDto();
        updateEventDto.setId(1L);
        return updateEventDto;
    }

    public static List<String> getUpdatedEventTags() {
        return List.of("Social");
    }

    public static List<TagUaEnDto> getUpdatedEventTagUaEn() {
        return List.of(TagUaEnDto.builder().nameEn("Social").nameUa("Сщціальний").build());
    }

    public static List<EventDateLocationDto> getUpdatedEventDateLocationDto() {
        return List.of(EventDateLocationDto.builder().startDate(ZonedDateTime.now()).finishDate(ZonedDateTime.now())
            .coordinates(CoordinatesDto.builder().latitude(1L).longitude(1L).build()).build());
    }

    public static EventDateLocation getUpdatedEventDateLocation() {
        return EventDateLocation.builder().startDate(ZonedDateTime.now()).finishDate(ZonedDateTime.now())
            .coordinates(Coordinates.builder().latitude(1L).longitude(1L).build()).build();
    }

    public static Event getEventWithGrades() {
        Event event = new Event();
        event.setDescription("Description");
        event.setId(1L);
        event.setOrganizer(getUser());
        event.setTitle("Title");
        List<EventDateLocation> dates = new ArrayList<>();
        dates.add(new EventDateLocation(1L, event,
            ZonedDateTime.of(2000, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2000, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        dates.add(new EventDateLocation(2L, event,
            ZonedDateTime.of(2002, 1, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            ZonedDateTime.of(2002, 2, 1, 1, 1, 1, 1, ZoneId.systemDefault()),
            new Coordinates(45.45, 45.45, "Ua Address", "En Address"), null));
        event.setDates(dates);
        event.setTags(List.of(getEventTag()));
        event.setTitleImage(AppConstant.DEFAULT_HABIT_IMAGE);
        event.setEventGrades(List.of(EventGrade.builder().grade(2).event(event).build()));
        return event;
    }

    public static Principal getPrincipal() {
        return () -> "danylo@gmail.com";
    }

    public static UserFilterDtoRequest getUserFilterDtoRequest() {
        return UserFilterDtoRequest.builder()
            .userRole("USER")
            .name("Test_Filter")
            .searchCriteria("Test")
            .userStatus("ACTIVATED")
            .build();
    }

    public static UserFilterDtoResponse getUserFilterDtoResponse() {
        return UserFilterDtoResponse.builder()
            .id(1L)
            .userRole("ADMIN")
            .searchCriteria("Test")
            .userStatus("ACTIVATED")
            .name("Test")
            .build();
    }

    public static Filter getFilter() {
        return Filter.builder()
            .id(1L)
            .name("Test")
            .user(new User())
            .type("USERS")
            .values("Test;ADMIN;ACTIVATED")
            .build();
    }

    public static AddEventCommentDtoResponse getAddEventCommentDtoResponse() {
        return AddEventCommentDtoResponse.builder()
            .id(getEventComment().getId())
            .author(getEventCommentAuthorDto())
            .text(getEcoNewsComment().getText())
            .build();
    }

    public static EventComment getEventComment() {
        return EventComment.builder()
            .id(1L)
            .text("text")
            .createdDate(LocalDateTime.now())
            .user(getUser())
            .event(getEvent())
            .build();
    }

    public static EventCommentVO getEventCommentVO() {
        return EventCommentVO.builder()
            .id(278L)
            .user(UserVO.builder()
                .id(13L)
                .role(Role.ROLE_ADMIN)
                .name("name")
                .build())
            .text("I find this topic very useful!")
            .createdDate(LocalDateTime.of(2020, 11, 7, 12, 42))
            .event(EventVO.builder()
                .id(32L)
                .build())
            .build();
    }

    public static EventCommentAuthorDto getEventCommentAuthorDto() {
        return EventCommentAuthorDto.builder()
            .id(getUser().getId())
            .name(getUser().getName().trim())
            .userProfilePicturePath(getUser().getProfilePicturePath())
            .build();
    }

    public static AddEventCommentDtoRequest getAddEventCommentDtoRequest() {
        return new AddEventCommentDtoRequest("text");
    }

    public static EventCommentDto getEventCommentDto() {
        return EventCommentDto.builder()
            .id(1L)
            .author(getEventCommentAuthorDto())
            .text("text")
            .build();
    }

    public static EventVO getEventVO() {
        return EventVO.builder()
            .id(1L)
            .description("description")
            .organizer(getUserVO())
            .title("title")
            .titleImage("title image")
            .build();
    }

    public static EventCommentForSendEmailDto getEventCommentForSendEmailDto() {
        return EventCommentForSendEmailDto.builder()
            .id(1L)
            .organizer(ModelUtils.getEventAuthorDto())
            .createdDate(LocalDateTime.now())
            .author(ModelUtils.getEventCommentAuthorDto())
            .text("text")
            .build();
    }

    public static EventAuthorDto getEventAuthorDto() {
        return EventAuthorDto.builder()
            .id(1L)
            .name("Inna")
            .organizerRating(1.0)
            .build();
    }

    public static UserShoppingAndCustomShoppingListsDto getUserShoppingAndCustomShoppingListsDto() {
        return UserShoppingAndCustomShoppingListsDto.builder()
            .userShoppingListItemDto(List.of(getUserShoppingListItemResponseDto()))
            .customShoppingListItemDto(List.of(getCustomShoppingListItemResponseDto()))
            .build();
    }
}
