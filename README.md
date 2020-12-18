# HiltCleanArchitecture
A Clean Architecture App to show use of Hilt in a multi-module architecture

This app is a PoC to showcase the use of Hilt in a multi module architecture. The modules are as follow:
  1. app: Presentation Layer
  2. domain: Business Logic Layer
  3. data: Data Access Layer
  
Some major highlights and libraries used are:
  1. Hilt 
  2. Dagger
  3. Coroutines
  4. Retrofit
  5. View Binding
  6. Clean Architecture based on Uncle Bob
  7. SOLID principles
 
The app has two branches:
  1. master: This is a skeleton branch which you can used to suit your use case.
  2. loginFlow: This is a branch based on the master which shows a dummy login flow.
  
More on loginFlow branch:

This branch is showcasing how to use Custom Scopes and Components with Hilt which is a bit tricky to implement. The scope is @LoggedInScope and the custom component is 
UserComponent. Please have a look at it and contribute if you feel so.
