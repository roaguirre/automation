
Scenario: Search for a video
Given I am at 'https://google.com'
Given I am at 'https://cuidemonos.app'
Given I am at 'https://ayfmarket.cl'
Given I am on YOUTUBE_HOME page
When I search for 'never gonna give you up'
Then I should see 'Rick Astley' text on the page