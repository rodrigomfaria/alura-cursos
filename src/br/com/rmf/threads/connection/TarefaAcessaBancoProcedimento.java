package br.com.rmf.threads.connection;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (pool) {

			System.out.println("Peguei a chave do pool - P");
			pool.getConnection();

			synchronized (tx) {

				System.out.println("Peguei a chave da tx - P");
				tx.begin();
			}
		}

	}
}
