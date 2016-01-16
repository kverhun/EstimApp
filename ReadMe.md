# EstimApp

_EstimApp_ --- android application designed to meet needs of task estimating group members.

_EstimApp_ allows you make independent voting about target task complexity or time consuming, just like if you use traditional estim cards, but convenient.
Your decision is synchronized with other ones at the remote server managed by scrum master.
When whole set of tasks estimation done, it results in the objective task estimation doc can be stored in convenient format on the server and shared between each estimation participant.

## Typical workflow for mobile device user:
  1. Sign in
  2. Wait for item to estimate
  3. Make estim
  4. Repeat step 2-3 while items are arriving from server
  5. Watch estimation session summary
  6. Log out

## UI forms
You can find
[here](https://github.com/kverhun/EstimApp/tree/Unit-tests-for-UI/docs/screenshots)
list of UI forms.

## UI graph
You can find 
[here](https://github.com/kverhun/EstimApp/blob/master/docs/UI_graph.pdf) 
UI form transition graph.

## Profiling report
You can find 
[here](https://github.com/kverhun/EstimApp/tree/master/docs/profiling) 
profiling result.  
[Note](https://raw.githubusercontent.com/kverhun/EstimApp/master/docs/profiling/RAM_usage.png), our application uses up to 7 MB RAM.  
Taking to account that server access operation may take some time, we have developed the application using 
[asynchronous tasks](https://raw.githubusercontent.com/kverhun/EstimApp/master/docs/profiling/asynchronous_tasks.jpg).

## Project contributors:
  - Kostiantyn Verhun
  - Serhii Sakharov
  - Oleksandra Fedchenko
