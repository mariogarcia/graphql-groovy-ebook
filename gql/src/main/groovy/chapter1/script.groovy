@Grab('com.github.grooviter:gql-core:0.2.0')
import gql.DSL

def GraphQLFilm = DSL.type('Film') { // <1>
  field 'title', GraphQLString
  field 'year', GraphQLInt
}

def schema = DSL.schema { // <2>
  queries {
    field('lastFilm') {
      type GraphQLFilm
      staticValue(title: 'SPECTRE', year: 2015)
    }
  }
}

def query = """
  {
    lastFilm {
      year
      title
    }
  }
"""

def result = DSL.execute(schema, query) // <3>

assert result.data.lastFilm.year == 2015
assert result.data.lastFilm.title == 'SPECTRE'
