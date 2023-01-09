### Java Flight API example


#### Choices
Chose not to handle the validation on the client side requests/responses.\
In normal circumstances I would have validated against values stated in the docs.\
Chose to use Gradle as the build tool. Research shows that this is markedly faster than Maven now.


#### Improvements / Wish list
Running the Airport codes against an API/Dataset, to ascertain whether they were existing airport codes.\
Probably would've handled the date conversion better in regards to timezones.\
Better logging, including custom logging interfaces to customise data piped to stdout.
Could've delved deeper into Parallelization and Streams.
The program is not optimised for memory.

#### Assumptions
Assumed that the discount percentage returned from the ToughJet API would be in integer form and a whole number
IE. 10% would be returned as 10.
