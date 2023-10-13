# Metriport Java Library

[![Maven Central](https://img.shields.io/maven-central/v/com.metriport/metriport-java)](https://central.sonatype.com/artifact/com.metriport/metriport-java)
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

## Documentation

API reference documentation is available [here](https://docs.metriport.com/home/welcome).

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'com.metriport:metriport-java:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>com.metriport</groupId>
    <artifactId>metriport-java</artifactId>
    <version>0.x.x</version>
</dependency>
```

## Usage
Both the Medical and Devices APIs are accessible from the SDK.

```typescript
import com.metriport.api.Metriport;
import com.metriport.api.resources.commons.types.Address;
import com.metriport.api.resources.medical.organization.types.BaseOrganization;

Metriport metriport = Metriport.builder()
  .apiKey("YOUR_API_KEY")
  .build();
  
var response = metriport.medical().organization().create(BaseOrganization.builder()
  .name("Metriport Inc.")
  .type(OrgType.PostAcuteCare)
  .location(Address.builder()
    .addressLine1("2261 Market Street")
    .addressLine1("#4818")
    .city("San Francisco")
    .state(UsState.CA)
    .zip("94114")
    .country("USA")
    .build())
  .build());

System.out.printlin("Received response!" + response);
```

### Handling Errors
When the API returns a non-success status code (4xx or 5xx response),
a subclass of [ApiError](src/main/java/com/metriport/api/core/ApiError.java)
will be thrown:

```ts
import com.metriport.api.core.ApiError;

try {
  api.medical().organization.create(...);
} catch (ApiError error) {
  System.out.println(error.getBody());
  System.out.println(error.getStatusCode());
}
```

## Staged Builders
The generated builders all follow the staged builder pattern. 
Read more [here](https://immutables.github.io/immutable.html#staged-builder).
Staged builders only allow you to construct the object once all required 
properties have been specified. 

For example, in the snippet below, you will not be able to access the build
method on `BaseOrganization` until you have specified the mandatory properties
name, type and location.

```java
import com.metriport.api.resources.medical.organization.types.BaseOrganization;

// Doesn't compile
BaseOrganization org = BaseOrganization.builder()
  .name(...)
  .type(...)
  .build(); 

// Compiles
BaseOrganization org = BaseOrganization.builder()
  .name(...)
  .type(...)
  .location(...)
  .build(); 
```

## Beta status
This SDK is in beta, and there may be breaking changes between versions 
without a major version update. Therefore, we recommend pinning the package
version to a specific version in your build.gradle file. This way, you can 
install the same version each time without breaking changes unless you are
intentionally looking for the latest version.

## Contributing
While we value open-source contributions to this SDK, this library 
is generated programmatically. Additions made directly to this library 
would have to be moved over to our generation code, otherwise they would 
be overwritten upon the next generated release. Feel free to open a PR as a
proof of concept, but know that we will not be able to merge it as-is. 
We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
