Feature: Trendyol Search Functionality

  Scenario: 1. User can search for a keyword
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Elbise"git add README.md
    And the user is click search icon
    Then the search function should work correctly text "Elbise"

  Scenario: 2. Dress search results appear in the main place
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Elbise"
    And the user is click search icon
    Then the search function should work correctly text "Elbise" in the page

  Scenario: 3. Contains the word dress in the relevant results field in the search field
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Elbise"
    Then Listing the word "Elbise" in the list

  Scenario: 4. Checking the relevant results by performing a history search in the search field
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Elbise"
    And the user is click search icon
    Then the search function should work correctly text "Elbise"
    When the user searches for ""
    Then the user is seen "Geçmiş Aramalar" and "Elbise"

  Scenario: 5. Wrong Call Check (Sample data: //**)
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "//**"
    Then seen "404" page

  Scenario: 6. Wrong Call Check (Sample data: 8965)
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "8965"
    Then the search function should work correctly text "8965" in the page

  Scenario: 7. Control of selecting and listing relevant data from popular search
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Elbise"
    And the user is click search icon
    Then the search function should work correctly text "Elbise"
    When the user searches for ""
    Then the user is seen popular search "Popüler Aramalar"
    When the user click on the one popular text
    Then the search function should work correctly text in the page

  Scenario: 8.Control of selecting and listing data from categories specific to you
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Elbise"
    And the user is click search icon
    Then the search function should work correctly text "Elbise"
    When the user searches for ""
    Then the user is seen categories field search "Sana Özel Kategoriler"
    When the user click on the one categories field text
    Then the search Categories text should work correctly text in the page

  Scenario: 9. Recommended order is checked
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Elbise"
    And the user is click search icon
    Then the search function should work correctly text "Elbise"
    When recommended sort check text "Önerilen sıralama"
    Then page is checked "https://www.trendyol.com/sr?q=Elbise&qt=Elbise&st=Elbise&os=1" url

  Scenario: 10.Listing of terms related to the relevant word
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user only searches for "Tem"
    Then Listing the word "Tem" and full text "Dil Temizleyici" in the list

  Scenario: 11.Showing suggestion searches of terms related to the relevant word
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Temizleyici"
    Then category suggestions for search appear

  Scenario: 12.Deleting history search
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user searches for "Elbise"
    And the user is click search icon
    Then the search function should work correctly text "Elbise"
    When the user searches for ""
    And Click on the past search field
    Then Text field should not seen

  Scenario: 13.Size suggestions for "Dress" Search see message
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user only searches for "Elbise"
    Then sees suggestion texts "'Elbise' Araması için Boy Önerileri"

  Scenario: 14. "Elbise" Araması için Boy önerileri görmek "Case olusmadı"
    Given the user is on Trendyol homepage
    When the user is click accept for cookie
    And the user is click modal
    When the user only searches for "Elbise"
    Then sees examples texts "Kısa","Maxi","Midi","Mini","Regular","Standart","Uzun"






