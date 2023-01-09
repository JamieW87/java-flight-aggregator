### Java Flight API example

### Run information:

#### Have included a start.sh script to step through each command in order.\
Build  
Run unit tests  
Run integration test  
Run application

However if you want to run these seperately, please use the gradle commands:

```
./gradlew build
./gradlew run
./gradlew unit
./gradlew integration
```

#### Sample request JSON:
```json
{
    "origin":"LHR",
    "destination": "MIA",
    "departureDate": "2024-11-12",
    "returnDate": "2023-12-01",
    "numberOfPassengers":3
}
```


### Choices
Chose not to handle the validation on the client side requests/responses.\
In normal circumstances I would have validated against values stated in the docs.\
Chose to use Gradle as the build tool. Research showed that this is markedly faster than Maven now.


### Improvements / Wish list
Running the Airport codes against an API/Dataset, to ascertain whether they were existing airport codes.\
Probably would've handled the date conversion better in regards to timezones.\
Better logging, including custom logging interfaces to customise data piped to stdout.\
The program is not optimised for memory.\
Better Status code error handling on HTTP responses.  
Secure endpoint(s) with JWTs or Bearer tokens.

### Assumptions
Assumed that the discount percentage returned from the ToughJet API would be in integer form and a whole number
IE. 10% would be returned as 10.\
Assumed the various status codes of the responses.

