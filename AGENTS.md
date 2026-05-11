# Scope

- These instructions apply to the entire `automation` repository.
- This repo contains Java-based web automation tests built with Maven, Selenium, JBehave, and JUnit.

# Layout

- `src/main/java/com/aguirreibarra/automation/` contains the test runner and automation code.
- `src/main/java/com/aguirreibarra/automation/sut/steps/` contains JBehave step implementations.
- `src/main/resources/stories/` contains JBehave story files.
- `pom.xml` defines Maven dependencies, compiler settings, and reporting plugins.
- `Dockerfile` and `Jenkinsfile` describe container and CI execution paths.

# Change Guidelines

- Keep changes focused on the automation behavior being modified; avoid broad refactors unless they simplify the touched path.
- Preserve clear separation between runner configuration, step definitions, and story content.
- Add or update docstrings/comments only when they explain behavior that is not obvious from the code.
- Use precise Java types and names for step methods, helper methods, and test data.
- Keep browser-dependent behavior explicit, including required system properties such as `story.name`.

# Validation

- Run `mvn validate` after metadata or configuration changes.
- Run `mvn test` after Java step, runner, dependency, or story changes.
- For browser-dependent scenarios, also run the relevant JUnit configuration for `com.aguirreibarra.automation.WebTest` with `-ea` and, when useful, `-Dstory.name=<StoryName>`.
