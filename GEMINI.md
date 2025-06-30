# Architecture
- Set up the project to follow Clean Architecture.
- Created `domain`, `data`, and `presentation` modules.
- The `domain` module is a pure Kotlin module.
- The `data` module is an Android library module and depends on the `domain` module.
- The `presentation` module is an Android library module and depends on the `domain` module.
- The `app` module depends on the `presentation` module.
- Created `.gitignore` files in `domain`, `data`, and `presentation` modules to exclude build artifacts.
- Untracked files that should be ignored by Git based on the `.gitignore` rules.


## Execute
 - 하나의 task를 작성하고 나면 gradlew 명령어를 사용해서 해당 코드가 제대로 동작하는지 확인하고 넘어간다.