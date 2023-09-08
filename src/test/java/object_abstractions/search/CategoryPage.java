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
}
