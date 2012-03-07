import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;


public class Etudiant {
	
	protected String nom;
	protected String prenom;
	protected String groupe;
	protected String lienPhoto;
	protected int numeroMifare;
	protected int numeroEtudiant;
	
	public Etudiant(String nom, String prenom, String groupe, String lienPhoto, int numeroMifare, int numeroEtudiant) {
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
		this.lienPhoto = lienPhoto;
		this.numeroMifare = numeroMifare;
		this.numeroEtudiant = numeroEtudiant;
	}
	
	public boolean telechargerPhoto() {
		try {
			URL adresse = new URL(this.lienPhoto);
			URLConnection con = adresse.openConnection();
			BufferedInputStream in = new BufferedInputStream(con.getInputStream());
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(this.numeroEtudiant + ".jpg"));
			byte[] read = new byte[1];
			int len = 1;
			while ((len = in.read(read)) > 0) {
				out.write(read, 0, len);
			}
			out.flush();
			out.close();
			in.close();
			return true;
		}
		catch (Exception e) {
			System.out.println("Erreur lors du téléchargement de la photo de " + this.nom + " " + this.prenom);
			return false;
		}
	}
}
