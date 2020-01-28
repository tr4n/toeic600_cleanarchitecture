package vn.sun.asterisk.domain.use.case

interface UseCase<in Param, out T> {
    suspend fun execute(param: Param): T
}

interface UseCaseNoParam<out T> {
    suspend fun execute(): T
}
