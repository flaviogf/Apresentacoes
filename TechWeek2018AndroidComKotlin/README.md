[1]: http://www.android.com
[2]: https://www.linuxfoundation.org
[3]: http://www.google.com
[4]: https://www.java.com/pt_BR
[5]: https://kotlinlang.org/

## Introdução

### Android

O [Android][1] é um sistema operacional baseado no núcleo do [Linux][2], atualmente mantido e desenvolvido pela [Google][3], projetado principalmente para dispositivos móveis como smartphones e tablets, mas atualmente o (SO) possui interfaces especificas para TV, carros e relogios  e pulso com as versões Android TV Android Auto e Android Wear respectivamente.

O Android é o sistema operacional mais utilizado no mundo ultrapassando as vendas de seus concorrentes somadas juntas, na conferência de 2014 realizada anualmente pela Google foi reveledo que no ano o SO possuia mais de 1 bilhão de usuários ativos. Em outra pesquisa realizada revelou-se também que mais de 70% dos programadores de dispositivos móveis desenvolvem para Android.

### Desenvolvimento

O Android fornece aos desenvolvedores uma estrutura de aplicativo que permite criar jogos e aplicativos para dispositivos móveis em um ambiente de linguagem [Java][4], para o desenvolvimento é importante que se entenda os seguintes conceitos:

* Pontos de entrada
* Adaptação para diferentes dispositivos

### Pontos de entrada

A criação de um aplicativo é realizada pela combinação de diferentes componentes, estes que podem ser chamados e invocados individualmente um exemplo seria a apresentação de uma interface para o usuário através de uma _atividade_ ou um _serviço_ que esteja realizando diversas operações em segundo plano no sistema operacional. Um componente também é capaz de inicializar um outro através de uma _intenção_. O modelo apresentado em questão de possuir vários pontos de entrada para uma mesma aplicação possibilita que um unico aplicativo se comporte como o "padrão" para uma determinada ação do usuário por exemplo de interceptar um mesagem sms ou email, chamada de voz ou abrir um determinada localização em um mapa.

### Adaptação para diferentes dispositivos

O Android fornece uma estrutura de layout que permite a criação de interfaces que se adaptam a tela dos varios dispositivos com diversas resoluções através
de suas definições feitas em arquivos XML estes serão determinados para exibição pelo próprio SO.

## Kotlin

### O que é Kotlin?

[Kotlin][5] é uma linguagem de tipagem estática para o desenvolvimento de aplicações modernas multiplataforma, com ela é possível construir aplicativos que rodam
na JVM, Android e Browser, é uma linguagem concisa, segura e interoperável. Com seu recém lançamento muito tem se especulado a respeito do fim da antiga linguagem Java.

### Comparação entre Java e Kotlin

#### Alguns do problemas do Java corrigidos pelo Kotlin

* Referências nulas controladas pelo sistema de tipos
* Arrays em Kotlin são imutáveis
* Kotlin possui o tipo função, ao contrário das conveções estabelecidadas pela da SAM
* No kotlin o desenvolvedor não é forçado a tratar exceções

#### O que o Java tem que o Kotlin não tem

* Tipos primitivos
* Membros estáticos
* Operador ternário
* Obrigação de tratar exceções

#### O que o Kotlin tem que o Java não tem

* Expressões lambdas com funções inline
* Extensões de funções
* Null-safety
* Smart casts
* String templates
* Propriedades
* Construtores primairos
* Inferencia de tipo
* Range expressions
* Sobrecarga de operadores
* Data classes
* Separação de interfaces somente leitura e coleções mutáveis

### Exemplos de códigos

#### Java vs Kotlin

##### Java
```java
    public class Hello {

        public static void (String[] args) {
            System.out.print("Olá mundo!");
        }
    }
```

##### Kotlin
```kotlin
    fun main() = print("Olá mundo!")
```

##### Java
````java
    int numero1 = 1;
````

##### Kotlin
```kotlin
    var numero1: Int = 1
    var numero2 = 2
    val numero3 = 3
```

##### Java
```java
    public class Address {

        private String street;

        private int streetNumber;

        private String postCode;

        private String city;

        private Country country;

        public Address(
          String street,
          int streetNumber,
          String postCode,
          String city,
          Country country) {

            this.street = street;

            this.streetNumber = streetNumber;

            this.postCode = postCode;

            this.city = city;

            this.country = country;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Address address = (Address) o;

            if (streetNumber != address.streetNumber)
              return false;

            if (!street.equals(address.street))
              return false;

            if (!postCode.equals(address.postCode))
              return false;

            if (!city.equals(address.city))
              return false;

            return country == address.country;
        }

        @Override
        public int hashCode() {
            int result = street.hashCode();

            result = 31 * result + streetNumber;

            result = 31 * result + postCode.hashCode();

            result = 31 * result + city.hashCode();

            result = 31 * result + (
              country != null
              ? country.hashCode()
              : 0
            );

            return result;

        }

        @Override

        public String toString() {

            return "Address{" +
                    "street='" + street + '\'' +

                    ", streetNumber=" + streetNumber +

                    ", postCode='" + postCode + '\'' +

                    ", city='" + city + '\'' +

                    ", country=" + country +
                    
                    '}';

        }

        public String getStreet() {

            return street;

        }

        public void setStreet(String street) {

            this.street = street;

        }

        public int getStreetNumber() {

            return streetNumber;

        }

        public void setStreetNumber(int streetNumber) {

            this.streetNumber = streetNumber;

        }

        public String getPostCode() {

            return postCode;

        }

        public void setPostCode(String postCode) {

            this.postCode = postCode;

        }

        public String getCity() {

            return city;

        }

        public void setCity(String city) {

            this.city = city;

        }

        public Country getCountry() {

            return country;

        }

        public void setCountry(Country country) {

            this.country = country;

        }

    }
```

##### Kotlin 
```kotlin
    data class Address(
        val street: String,
        val streetNumber: Int,
        val postCode: String,
        val city: String,
        val country: Country)
```

## Kotlin como linguagem oficial para desenvolvimento de aplicativos Android

Com a versão 3.0 do ambiente de desenvolvimento Android Studio em maio de 2017 no evento Google/IO foi anunciado oficialmente o suporte a desenvolvimento de aplicativos android com Kotlin, e desde então a Google vem demonstrando uma forte adoção pela linguagem reescrevendo toda a sua documentação com exemplos feitos na nova linguagem.

![Java velho](https://cdn-images-1.medium.com/max/740/1*52sYUe1ormGh4lRQWurvbg.png)
