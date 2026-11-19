# Domain model entities

This package is retained to mirror the `learning/domain/model/entities` layer.

The current Open Treatment requirements define `Disease` as the domain entity and Aggregate Root. They do not define a separate internal entity with its own identity, lifecycle, and behavior. Therefore, no artificial Java entity is added here. `Disease` remains in `aggregates`, while `DiseasePersistenceEntity` is kept separately in infrastructure/JPA.
