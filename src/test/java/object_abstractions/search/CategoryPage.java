package object_abstractions.search;

public class CategoryPage {
    // List all of the elements used to verify scenario Access product after apply multiple filters
    public String XPATH_HOME_MENU = "//*[@class='hl-cat-nav__active']/span";
    public String ID_SHOP_BY_CATEGORY_DROPDOWN = "gh-shop-a";
    public String XPATH_SUB_CATEGORY_ACCESSORIES = "//*[@class='seo-breadcrumb-text']/span";
    public String XPATH_SUB_CATEGORY_SMARTPHONE = "//*[@class='b-textlink b-textlink--parent' and text() = 'Cell Phones & Smartphones']";
    public String XPATH_SECTION_BRAND = "//*[@class='section-title__title' and text() = 'Shop by Brand']";
    public String XPATH_IMAGE_PRODUCTS = "b-guidancecard__img";
    public String XPATH_SECTION_STORAGE = "//*[@class='section-title__title' and text() = 'Shop by Storage Capacity']";
    public String CLASS_LIST_PRODUCTS = "s-item__image-img";
    public String CLASS_ALL_FILTER_BUTTON = "brm__all-filters";
    public String CLASS_FILTER_WINDOW = "x-overlay__container";
    public String XPATH_CONDITION_FILTER= "//*[@role='tab']/span[text()='Condition']";
    public String XPATH_CONDITION_NEW= "//*[@id='c3-subPanel-LH_ItemCondition_New']//descendant::input";
    public String XPATH_PRICE_FILTER= "//*[@role='tab']/span[text()='Price']";
    public String CLASS_PRICE_FROM= "x-textrange__input--from";
    public String XPATH_LOCATION_FILTER= "//*[@role='tab']/span[text()='Item Location']";
    public String XPATH_LOCATION_ASIA= "//*[@aria-label='Asia']";
    public String XPATH_APPLY_BUTTON= "//*[@aria-label='Apply']";
    public String XPATH_STR_FILTER_APPLIED= "//*[@class='brm__item brm__item--applied']//child::span[@class='brm__flyout__btn-label']";
    public String XPATH_BTN_FILTER_APPLIED= "//*[@class='brm__item brm__item--applied']//child::button[@class='x-flyout__button']";
    public String CLASS_RESULT_FILTER= "brm__item-label";
}
