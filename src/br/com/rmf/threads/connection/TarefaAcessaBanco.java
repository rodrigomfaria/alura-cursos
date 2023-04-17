package br.com.rmf.threads.connection;

public class TarefaAcessaBanco implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBanco(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (pool) {

			System.out.println("Peguei a chave do pool - T");
			pool.getConnection();

			synchronized (tx) {

				System.out.println("Peguei a chave da tx - T");
				tx.begin();

			}
		}
	}
}
