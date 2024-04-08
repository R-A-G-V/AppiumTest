Feature: Create New Task
  Scenario: El usuario agrega nueva tarea
    Given Click en agregar
    Given Agregar un nombre
    Given  Agregar una descripcion
    When Click en guardar
    Then Tarea agregada exitosamente