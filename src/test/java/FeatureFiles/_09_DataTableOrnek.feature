Feature: Datatable örnek

  Scenario: Users List

    When write username "ismet"
    And write username and password "ismet" and "1234"

    And write username as Datatable
      | ismet   |
      | mehmet  |
      | Ayşe    |
      | İbrahim |
      | Esma    |

    And write username and password as Datatable
      | ismet   | 1234 |
      | mehmet  | 4567 |
      | Ayşe    | 789  |
      | İbrahim | 3333 |
      | Esma    | 6666 |

 #  dataProvider (TestNG için), Senaryo Outline (cucumber)
 #  görevi verilen her değer için, tüm senayo çalışır

  #  DataTable ise , sadece bir step e, çoklu parametre vermek
 #  için kullanılır, sadece 1 kez tüm parametreleri stepin içine atar