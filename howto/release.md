# How to release a new Version

To release a new version to Maven Central, the following steps have to be completed:

1. Set the new version in [pom.xml](../pom.xml) (without `-SNAPSHOT`)
2. Commit the change locally with a matching comment like `Release X.Y`
3. Create a Git tag for the new Version named `vX.Y`
4. Push everything (including the tag) to Github
5. Use the [Github releases Page](https://github.com/WPS/common-contracts/releases) to draft (and publish) a new release named `vX.Y`
   based on the tag created in step 3. Make sure to use the `Generate changelog` functionality.

After the release has been published in Github the [maven-publish action](../.github/workflows/maven-publish.yml) will
run and the new release will be published to Maven Central