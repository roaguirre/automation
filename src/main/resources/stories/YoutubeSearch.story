
Scenario: Search for a video and check the results
Given I am at 'https://youtube.com'
Then I find 'Home' text on the page
And I find 'Explore' text on the page
And I find 'Subscriptions' text on the page
And I find 'Library' text on the page
And I find 'History' text on the page
When I search for 'never gonna give you up'
Then I find 'Rick Astley' text on the page