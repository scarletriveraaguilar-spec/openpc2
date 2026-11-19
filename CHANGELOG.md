# Changelog

## Open Treatment adaptation

- Adapted the Learning Center `learning` bounded context into `diagnosis` for disease registration.
- Retained the original `shared`, `iam`, and `profiles` bounded contexts and project infrastructure.


All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 2026-11-02

### Added
- TS-P001: Create a Profile.
- TS-P002: Get Profiles.
- TS-C001: Create a Course.
- TS-C002: Get a Course by Id.
- TS-C003: Get all Courses.
- TS-C004: Update a Course.
- TS-C005: Delete a Course.
- TS-LP001: Add a Tutorial to a Course Learning Path.
- TS-S001: Create a Student.
- TS-S002: Get Student by Acme Student Record Id.
- TS-E001: Request Enrollment.
- TS-E002: Confirm, Reject, and Cancel an Enrollment.
- TS-E003: Get All Enrollments.
- TS-S003: Get a Student's Enrollments.
- Complete a Tutorial.
- TS-IAM001: Sign-up.
- TS-U002: Get Available Roles.
- TS-IAM002: Sign-in.
- TS-U001: List Users and Get User by Id.
- TS-ARCH001: JWT Authentication and Authorization.
- TS-ARCH002: standardized RFC 9457 Problem Details error responses.
- TS-ARCH003: localized error messages (English/Spanish).
- `Result<T, E>` railway-oriented outcome type for every command handler.
- A value object for every domain primitive with a validation rule (`PersonName`, `EmailAddress`, `StreetAddress`, `AcmeStudentRecordId`, `ProfileId`, `TutorialId`, among others).
- Cross-context integration through an ACL facade and a published domain event (`profiles` → `learning`), never a direct domain dependency.
- Hexagonal persistence: no aggregate carries a JPA annotation.
- CQRS: command and query services as separate contracts, across all four bounded contexts.
- Swagger UI (`springdoc-openapi`) for manual API verification.
- Architecture Decision Records in `docs/adrs.md`, class diagram and C4 software architecture diagrams in `docs/`.
