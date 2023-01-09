#Build
echo "---Building---"
./gradlew build
#Unit test
echo "---Running unit tests---"
./gradlew unit
#Integration test
echo "---Running integration test---"
./gradlew integration

echo "---Running application---"
./gradlew run
