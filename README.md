# scala-library-template

A reusable template for Scala libraries, with automatic [Maven Central](https://central.sonatype.com/) deployment.

## Using this template

### 1. Create your repository

Click '**Use this template**' on GitHub, and follow the instructions to create a new repository.

### 2. Update `build.sbt`

Replace every `example` placeholder:

```scala
ThisBuild / organization := "com.yourorg"         // Maven group ID
ThisBuild / organizationName := "Your Org"
ThisBuild / organizationHomepage := Some(url("https://yourorg.com"))

ThisBuild / scmInfo := Some(ScmInfo(
  url("https://github.com/yourorg/your-library"),
  "scm:git@github.com:yourorg/your-library.git",
))

ThisBuild / developers := List(Developer(
  id = "yourhandle", name = "Your Name",
  email = "you@example.com", url = url("https://github.com/yourhandle"),
))

ThisBuild / description := "What your library does."
ThisBuild / homepage    := Some(url("https://github.com/yourorg/your-library"))
```

Change the root project `name` and replace the sample source files.

### 3. Set up Sonatype Central Portal

1. Create an account at <https://central.sonatype.com>.
2. Register your `groupId` namespace (e.g. `com.yourorg`).
3. Generate a **User Token** (Account → Generate User Token).

### 4. Generate a GPG key for signing

```bash
gpg --gen-key
# Note the key ID printed, e.g. ABCDEF1234567890

# Export the secret key as base64 (this becomes PGP_SECRET)
gpg --armor --export-secret-keys ABCDEF1234567890 | base64 | pbcopy

# Upload the public key to a keyserver
gpg --keyserver keyserver.ubuntu.com --send-keys ABCDEF1234567890
```

### 5. Add GitHub Actions secrets

Go to your repository → **Settings → Secrets and variables → Actions** and add:

| Secret | Value |
|--------|-------|
| `PGP_SECRET` | Base64-encoded GPG private key (from step 4) |
| `PGP_PASSPHRASE` | Passphrase used when generating the GPG key |
| `SONATYPE_USERNAME` | Sonatype Central Portal token username |
| `SONATYPE_PASSWORD` | Sonatype Central Portal token password |

### 6. Publishing workflow

| Event | Result |
|-------|--------|
| Push to `main` (any commit) | Publishes a `-SNAPSHOT` to Sonatype |
| Push a tag matching `v*` | Publishes a release to Maven Central |

To release version `1.2.3`:

```bash
git tag v1.2.3
git push origin v1.2.3
```

The CI pipeline will run tests, then publish and auto-promote the artifact to Maven Central.
