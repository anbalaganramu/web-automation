#Author: joseph Kennedy E
@Sanity
Feature: US Cocoa Sanity Testing

@LoginwithvalidCredentials @Login @Regression @Rerun
Scenario Outline: To verify if user is able to login with valid login credentials
Given Customer launches the website
When Customer enters email as "<Email>" and password as "<Password>"
Then Accept Cookies and Clicks login button
Then Verify customer is navigated to My Account "<Email>"
#  Then logout of the site

Examples: 
| Email                				| Password 	|
| josephkennedy.e@olamnet.com | Olam1234$ |

@Filter @Rerun
Scenario Outline: Verify user is able to filter the desired products
Given Customer launches the website
Given Navigate to "<Category>" Category page
Then Select a filter "<FilterCriteriaOne>" under Applications
And Verify number of products in product listing
Then Select a filter "<FilterCriteriaTwo>" under PH value
And Verify number of products in product listing
Then Select a filter "<FilterCriteriaThree>" under Color
And Verify number of products in product listing
Then Clear all the applied filter
Then Search a filter criteria "<SearchFilterCriteria>" and select
And Verify number of products in product listing
Then Clear all the applied filter

 Examples:
 |Category     |FilterCriteriaOne |FilterCriteriaTwo    |FilterCriteriaThree | SearchFilterCriteria |
 |Cocoa Powders|Bakery            |Natural (less than 6)|	Light Brown        | Sweet                |
 
 @Sorting
 Scenario Outline: Verify user is able to sort the products in Ascending and Descending
Given Navigate to "<Category>" Category page
When Customer selects a sorting option as "Product Name"
Then Verify products are sorted in Ascending order
When Customer clicks on Descending order
Then Verify products are sorted in Descending order

 Examples:
|Category      |
| Cocoa Powders|

@Pagination
Scenario Outline: Verify user is able to navigate to the listing pages using navigation
Given Navigate to "<Category>" Category page
When Customer selects the number of items per page as "12"
Then Click on Next icon
And Verify the URL contains page number
Then Click on page number
And Verify the URL does not contain page number

 Examples:
|Category      |
| Cocoa Powders|

@AddToFavorites
Scenario: Verify user is able to add items to favorites
Given Navigate to "Cocoa Powders" Category page
And Click on favorite icon for a product
Then Verify customer is redirected to My Favorites
And Verify product is added to favorites list
And Clear favorites list
Then Navigate to "Cocoa Powders" Category page
And Verify favorite icon is displayed as unselected

@Search
Scenario Outline: Verify user is able to search products
Given Customer launches the website
When Click on Search Icon from header
And Key in valid search term "<validSearchTerm>" and hit Enter
Then Verify Search results page shows products that contains search term "<validSearchTerm>"
And Key in incorrect search term "<inValidSearchTerm>" and hit Enter
And Verify the search result section for message "<searchResultMessage>"

 Examples:
|validSearchTerm      |inValidSearchTerm |searchResultMessage 																		|
| D11  								|Test							 |Sorry we can't find the product you're searching for    |

@NewsletterSignup
Scenario Outline: Verify customer can signup for newsletter
#Given Navigate to My Account page
When Signup for newsletter with "<Email>"
Then Verify the newsletter subscription success message "<successMessage>"

 Examples: 
      | Email                       |successMessage									 |
			|josephkennedy.e@olamnet.com  |Thank you for your subscription |

@PlaceOrder
 Scenario Outline: To verify user is able to palce an order
 Given Customer navigates to Home page
 When Navigate to "<Category>" Category page
 And Switch to List View
 Then Clicks on product "<Item>"
 And Enter quantity for "<Package>" quantity as "<Quantity>" 
 Then Add the product to Cart
 And From mini cart click Checkout now
 #Then Add another shipping address
 #|Fields     |Values   |
 #|Company    |OTBS		 |
 #|PhoneNumber|random	 |
 #|StreetAddress|3343 Chapel Hills Pkwy|

 And Select shipping method
 Then Navigate to Payment page
 And Select Payment option
 And Place order
# Then Verify the order in My Orders section
#Then Navigate to My Account page
#And Verify the new Address in Address Book "<City>" and "<State>"

 
 Examples:
 |Category     |Item   |Package | Quantity |City   		 |State    |
# |Cocoa Powders|D11G	 |Bag     | 1        |Fultondale |Alabama  |
 |Cocoa Powders|D23F	 |Bag     | 1        |Fultondale |Alabama  |
 
 #@DeleteAddress
 #Scenario: To verify user is able to delete an address
 #Given Navigate to My Account page
 #Then Delete an address from Address Book
 #|Fields     |Values   																									 |
 #|Message    |You have no other address entries in your address book.		 |

@PlaceSampleOrder
 Scenario Outline: To verify user is able to palce sample order
 Given Customer navigates to Home page
 When Navigate to "<Category>" Category page
 And Switch to List View
 Then Clicks on product "<Item>"
 Then Clicks Request a Sample button
 And Verify quantity and price
 And From mini cart click Checkout now
 Then Navigate to Payment page
 And Check for No Payment Option
 And Place order for Sample Order
 
 Examples:
 |Category     |Item   |
 |Cocoa Powders|D11G	 |


@SampleAndSpotProductInSameCart
 Scenario Outline: To verify user is not allowed to add Spot and Sample product in same cart
 Given Customer navigates to Home page
 When Navigate to "<Category>" Category page
# And Switch to List View
 Then Clicks on product "<Item>"
 And Enter quantity for "<Package>" quantity as "<Quantity>" 
 Then Add the product to Cart
 And Close Mini Cart pop up
 Then Clicks Request a Sample button
 And Verify the Error message "<ErrorMessage>"
 
 Examples:
 |Category     |Item   |Package | Quantity | ErrorMessage																						 |
 |Cocoa Powders|D11G	 |Bag     | 1        |Both spot & sample products are not allowed in same cart |
 
 @ChangePassword
Scenario Outline: Verify customer can change the password and login with New Password
Given Navigate to My Account page
When Click on Change Password link
Then Change Password and Save "<OldPassword>" "<NewPassword>"
When Customer enters email as "<Email>" and password as "<NewPassword>"
Then Clicks login button
Then Verify customer is navigated to My Account "<Email>" 

 Examples:
|OldPassword      |NewPassword |Email 											|
| Olam1234$       |Olam1234$   |josephkennedy.e@olamnet.com |

@SignOut
Scenario Outline: Verify user is able to Sign out
When clicks on Sign out from user profile
Then verify url contains "<SignOutURLText>"
 Examples:
|SignOutURLText      |
| logoutSuccess			 |

@HidePricingForGuestUser
Scenario: Verify Hiding price details for guest user
Given Navigate to "Cocoa Powders" Category page
When Check starting price for a product is showing as "Login For Price"

