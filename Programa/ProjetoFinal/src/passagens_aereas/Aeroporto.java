/*
Instruções:

Leia atentamente todas as questões antes de resolvê-las.
Utilizar o aplicativo NetBeans para desenvolver as questões desta prova.
Pode utilizar a consulta a materiais já salvos em seu aplicativo, é vedada a consulta a sites na internet ou a qualquer outro material escrito, incluindo materiais de aula.
Não será permitido a consulta a colegas. Desenvolva sua prova sozinho.
Quaisquer dúvidas referentes ao enunciado das questões deverão ser discutidas exclusivamente com a professora de forma restrita (em voz baixa).
Crie um novo projeto denominado Prova<SeuNome>. Ao encerrar a prova compacte o projeto e envie-o pelo Moodle para avaliação.
Horário de término da realização e postagem: 20h20min



public String arquivo()throws IOException  {
        String nome = TextoUsuario.getText();
        String senha = SenhaUsuario.getText();
        Date dataAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String data = sdf.format(dataAtual);
        System.out.println("Data é" + data);

        File arquivo = new File("arquivo.txt");

        FileWriter inserindo = new FileWriter(arquivo, true);
        inserindo.write(nome);
        inserindo.write(senha);
        inserindo.write(data);
        inserindo.close();


        String ret = "\nArquivo foi gravado com sucesso";
        return ret;
    }

BufferedReader br = new BufferedReader(new FileReader("c:/arquivo.html"));
while(br.ready()){
   String linha = br.readLine();
   System.out.println(linha);
}
br.close();
*/


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passagens_aereas;

/**
 *
 * @author João Victor Lima
 * @author Lucas Vanjura
 */
public class Aeroporto {

    private int registro;
    private String nome;
    private String cidade;
    private String estado;

    public Aeroporto() {
    }

    public Aeroporto(String nome, String cidade, String estado) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
