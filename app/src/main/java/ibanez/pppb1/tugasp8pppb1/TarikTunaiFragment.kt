package ibanez.pppb1.tugasp8pppb1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ibanez.pppb1.tugasp8pppb1.databinding.FragmentTarikTunaiBinding

class TarikTunaiFragment : Fragment() {
    private var _binding: FragmentTarikTunaiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTarikTunaiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnTarik.setOnClickListener {
            val nominal = binding.edtNominal.text.toString()
            Toast.makeText(requireContext(), "Rp$nominal telah ditarik.", Toast.LENGTH_SHORT).show()
            findNavController().previousBackStackEntry?.savedStateHandle?.set("nominal", nominal)
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}