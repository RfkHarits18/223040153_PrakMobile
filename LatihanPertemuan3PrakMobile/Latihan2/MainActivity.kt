import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import id.ac.unpas.formregistrasi.ui.theme.FormRegistrasiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormRegistrasiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormRegistrasi()
                }
            }
        }
    }
}

@Composable
fun FormRegistrasi() {
    val context = LocalContext.current

    var nama by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var nomorTelepon by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = nomorTelepon,
            onValueChange = { nomorTelepon = it },
            label = { Text("Nomor Telepon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                if (nama.isNotBlank() && username.isNotBlank() && nomorTelepon.isNotBlank() &&
                    email.isNotBlank() && alamat.isNotBlank()
                ) {
                    Toast.makeText(context, "Halo, $nama", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Semua inputan harus diisi", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Simpan")
            }

            Button(onClick = {
                nama = ""
                username = ""
                nomorTelepon = ""
                email = ""
                alamat = ""
            }) {
                Text("Reset")
            }
        }
    }
}

