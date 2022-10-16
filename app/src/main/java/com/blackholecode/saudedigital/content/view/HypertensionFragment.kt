package com.blackholecode.saudedigital.content.view

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.blackholecode.saudedigital.R
import com.blackholecode.saudedigital.common.base.DependencyInjector
import com.blackholecode.saudedigital.common.extension.toastGeneric
import com.blackholecode.saudedigital.common.model.MContent
import com.blackholecode.saudedigital.content.Content
import com.blackholecode.saudedigital.content.base.ContentBaseFragment
import com.blackholecode.saudedigital.databinding.FragmentContenContentBinding
import java.util.*

class HypertensionFragment : ContentBaseFragment<FragmentContenContentBinding, Content.Presenter>(
    R.layout.fragment_conten_content,
    FragmentContenContentBinding::bind
), Content.View {

    override lateinit var presenter: Content.Presenter

    override fun setupPresenter() {
        presenter = DependencyInjector.contentPresenter(this)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setupView() {
        presenter.fetchContent("hypertension")

        binding?.let { binding ->
            with(binding) {
                val list = mutableListOf<MContent>()
                for (i in 0 until 10) {
                    list.add(
                        MContent(
                            id = UUID.randomUUID().toString(),
                            thumbnail = R.drawable.ic_heart,
                            title = "Hipertensão$i",
                            description = getString(R.string.lorem),
                            videoUrl = "",
                            type = "hypertension"
                        )
                    )
                }

                adapterRv.items = list.toMutableList()
                adapterRv.notifyDataSetChanged()

                contentRecycler.layoutManager = LinearLayoutManager(requireContext())
                contentRecycler.adapter = adapterRv
            }
        }
    }

    override fun showProgress(enabled: Boolean) {
        binding?.contentProgress?.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun displayRequestSuccessful(data: List<MContent>) {
        binding?.contentListEmpty?.visibility = View.GONE
        binding?.contentRecycler?.visibility = View.VISIBLE
        adapterRv.items = data.toMutableList()
        adapterRv.notifyDataSetChanged()
    }

    override fun displayRequestEmptyList() {
        binding?.contentRecycler?.visibility = View.GONE
        binding?.contentListEmpty?.visibility = View.VISIBLE
    }

    override fun displayRequestFailure(message: String) {
        toastGeneric(requireContext(), message)
    }

}