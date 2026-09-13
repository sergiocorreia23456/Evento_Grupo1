package grupo1;

	public class Evento {

		private String titulo;
		private String data;
		private String local;
		private int lotacaoMaxima;
		
		public Evento(String titulo, String data, String local, int lotacaoMaxima) {
			
			this.titulo=titulo;
			this.data=data;
			this.local=local;
			this.lotacaoMaxima=lotacaoMaxima;
			
		}
		
		public String getTitulo() {
			return titulo;
			
		}
		
		public String getData() {
			return data;

		}
		
		public String getLocal() {
			return local;
			
		}
		
		public int getLotacaoMaxima() {
			return lotacaoMaxima;
			
		}
		
		public void setTitulo(String titulo) {
			this.titulo=titulo;
			
		}
		
		public void setData(String data) {
			this.data=data;
			
		}
		
		public void setLocal(String local) {
			this.local=local;
			
		}
		
		public void setLotacaoMaxima(int lotacaoMaxima) {
			this.lotacaoMaxima=lotacaoMaxima;
			
		}
		
		public String mostrarEvento() {
			return "Evento[" + titulo + "-" + data + "-" + local + "-" + lotacaoMaxima + "]";
			
		}
		
	}
       