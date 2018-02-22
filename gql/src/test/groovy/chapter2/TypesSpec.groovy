package chapter2

import gql.DSL
import spock.lang.Specification

import graphql.ExecutionResult
import graphql.schema.GraphQLSchema

class TypesSpec extends Specification {

    void 'simple example of GQL'() {
        given: 'a specific type'
        // tag::type[]
        def SystemType = DSL.type('SystemType') {
            field 'freeDisk', GraphQLLong
            field 'freeMemory', GraphQLInt
        }
        // end::type[]

        when: 'creating a query'
        def query = '''
        {
          system {
            freeDisk
            freeMemory
          }
        }
        '''

        and: 'executing the query'
        GraphQLSchema schema = DSL.schema {
            queries {
                field('system') {
                    type SystemType
                    fetcher {
                        return [
                            freeDisk: new File('/').freeSpace,
                            freeMemory: Runtime.runtime.freeMemory()
                        ]
                    }
                }
            }
        }
        ExecutionResult result = DSL.execute(schema, query)

        then: 'we should get the expected fields'
        result.data.system.freeDisk
        result.data.system.freeMemory
    }
}
