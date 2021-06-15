
Scenario: Search for a video
Given I am at 'https://youtube.com'
When I wait for 5 seconds
Then I should see 'Home' text on the page
And I should see 'Explore' text on the page
And I should see 'Subscriptions' text on the page
And I should see 'Library' text on the page
And I should see 'History' text on the page
When I search for 'never gonna give you up'