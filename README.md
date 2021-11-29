## Reproducer project for Groovy issue with static import for println
This project demonstrates breaking change between groovy 2.5.0 and 2.5.1 
causing previous behaviour of static import for println method to stop working

It is no longer possible to provide custom implementation of println method using ImportCustomizer
- Command `./gradlew workingTest` demonstrates behaviour of Groovy 2.5.0 which correctly invokes custom println method
- Command `./gradlew brokenTest` demonstrates behaviour of Groovy 2.5.1 which invokes DefaultGroovyMethods implementation of println method even though static import is present