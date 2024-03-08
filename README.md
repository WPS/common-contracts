# WPS common contracts

This project contains a set of contracts for _design by contract_. The contracts follow the following naming scheme:

- Methods starting with __require__ are preconditions, which are used to check arguments
- Methods starting with __check__ are state checks or invariants, which are used to check intermediate results for consistency
- Methods starting with __ensure__ are postconditions, which are used to check results before returning them 

## Maven coordinates

Releases can be found in Maven central under the following coordinates:
```xml
<dependency>
    <groupId>de.wps.common</groupId>
    <artifactId>common-contracts</artifactId>
    <version>0.3</version>
</dependency>
```

## The contracts

The (static) methods implementing different contracts are grouped in the following classes:

- [`BaseContracts`](./src/main/java/de/wps/common/contracts/BaseContracts.java) to test for nullability and simple boolean conditions.
- [`CollectionContracts`](./src/main/java/de/wps/common/contracts/CollectionContracts.java) to test collections for nullability and emptiness.
- [`StringContracts`](./src/main/java/de/wps/common/contracts/StringContracts.java) to test strings for emptiness and blankness (and nullability).