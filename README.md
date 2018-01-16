# Payara micro environment variable substitution issue

When using a singleton EJB annotated with @Startup environment variable substitution happens to late.

## Build project
```bash
mvn clean package
```

## Start payara micro
```bash
MY_ENV=myVal java -jar payara-micro-4.1.2.174.jar --deploy target/payara-issue.war
```

## Access resource
```bash
curl http://localhost:8080/payara-issue/
${ENV=MY_ENV} // output
```

Removing the @Startup annotation from the ResourceBean class and repeating the steps above produces

```bash
curl http://localhost:8080/payara-issue/
myVal // output
```

